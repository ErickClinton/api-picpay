package tech.erick.picpay.module.tansfer;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.erick.picpay.client.authorization.AuthorizationService;
import tech.erick.picpay.client.notification.NotificationService;
import tech.erick.picpay.exception.InsufficientBalanceException;
import tech.erick.picpay.exception.TransferNotAllowedForWalletTypeException;
import tech.erick.picpay.exception.TransferNotAuthorizedException;
import tech.erick.picpay.exception.WalletNotFoundException;
import tech.erick.picpay.module.tansfer.dto.TransferDto;
import tech.erick.picpay.module.tansfer.entity.TransferEntity;
import tech.erick.picpay.module.wallet.entity.WalletEntity;
import tech.erick.picpay.module.wallet.repositories.WalletRepository;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferService {
    private final NotificationService notificationService;
    private final AuthorizationService authorizationService;
    private final TransferRepository transferRepository;
    private final WalletRepository walletRepository;

    public TransferService(NotificationService notificationService, AuthorizationService authorizationService, TransferRepository transferRepository, WalletRepository walletRepository) {
        this.notificationService = notificationService;
        this.authorizationService = authorizationService;
        this.transferRepository = transferRepository;
        this.walletRepository = walletRepository;
    }

    @Transactional
    public TransferEntity transfer(TransferDto transferDto) {
        var sender = walletRepository.findById(transferDto.payer())
                .orElseThrow(()-> new WalletNotFoundException(transferDto.payer()));

        var receiver = walletRepository.findById(transferDto.payee())
                .orElseThrow(()-> new WalletNotFoundException(transferDto.payee()));

        validateTransfer(transferDto,sender);
        sender.debit(transferDto.value());
        receiver.credit(transferDto.value());

        var transfer = new TransferEntity(sender,receiver,transferDto.value());

        walletRepository.save(sender);
        walletRepository.save(receiver);
        var transferResult = transferRepository.save(transfer);

        CompletableFuture.runAsync(()-> notificationService.sendNotification(transferResult));

        return transferResult;
    }

    private void validateTransfer(TransferDto transferDto, WalletEntity sender) {

        if(!sender.isTransferAllowedForWalletType()) throw new TransferNotAllowedForWalletTypeException();
        if(!sender.isBalanceEqualOrGreaterThan(transferDto.value())) throw new InsufficientBalanceException();
        if(!authorizationService.isAuthorized(transferDto)) throw new TransferNotAuthorizedException();
    }
}

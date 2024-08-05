package tech.erick.picpay.module.wallet;

import org.springframework.stereotype.Service;
import tech.erick.picpay.exception.WalletDataAlreadyExistsException;
import tech.erick.picpay.module.wallet.dto.CreateWalletDto;
import tech.erick.picpay.module.wallet.entity.WalletEntity;
import tech.erick.picpay.module.wallet.repositories.WalletRepository;

@Service
public class WalletService {
    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }
    public WalletEntity create(CreateWalletDto createWalletDto) {
        var existUser = walletRepository.findByCpfCnpjOrEmail(createWalletDto.cpfCnpj(),createWalletDto.email());
        if(existUser.isPresent()){
            throw new WalletDataAlreadyExistsException("CpfCnpj or Email already exists");
        }
       return walletRepository.save(createWalletDto.toWallet());
    }
}

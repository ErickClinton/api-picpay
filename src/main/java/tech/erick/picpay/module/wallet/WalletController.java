package tech.erick.picpay.module.wallet;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.erick.picpay.module.wallet.dto.CreateWalletDto;
import tech.erick.picpay.module.wallet.entity.WalletEntity;

@RestController
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/wallets")
    public ResponseEntity<WalletEntity> create(@RequestBody @Valid CreateWalletDto createWalletDto){
        var wallet = walletService.create(createWalletDto);
        return ResponseEntity.ok(wallet);
    }
}

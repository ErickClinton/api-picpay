package tech.erick.picpay.module.wallet.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tech.erick.picpay.module.wallet.entity.WalletEntity;
import tech.erick.picpay.module.wallet.entity.WalletTypeEntity;

public record CreateWalletDto(@NotBlank String fullName,
                              @NotBlank String cpfCnpj,
                              @NotBlank String email,
                              @NotBlank String password,
                              @NotNull WalletTypeEntity.Enum walletType) {

    public WalletEntity toWallet(){
        return new WalletEntity(fullName,cpfCnpj,email,password,walletType().get());
    }
}

package tech.erick.picpay.module.wallet.dto;

import tech.erick.picpay.module.wallet.entity.WalletEntity;
import tech.erick.picpay.module.wallet.entity.WalletTypeEntity;

public record CreateWalletDto(String fullName, String cpfCnpj, String email, String password, WalletTypeEntity.Enum walletType) {

    public WalletEntity toWallet(){
        return new WalletEntity(fullName,cpfCnpj,email,password,walletType().get());
    }
}

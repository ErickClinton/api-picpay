package tech.erick.picpay.module.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.erick.picpay.module.wallet.entity.WalletTypeEntity;

public interface WalletTypeRepository extends JpaRepository<WalletTypeEntity,Long> {
}

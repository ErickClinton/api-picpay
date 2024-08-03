package tech.erick.picpay.module.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.erick.picpay.module.wallet.entity.WalletEntity;

public interface WalletRepository extends JpaRepository<WalletEntity,Long> {
}

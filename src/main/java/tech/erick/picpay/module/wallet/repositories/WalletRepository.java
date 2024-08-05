package tech.erick.picpay.module.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.erick.picpay.module.wallet.entity.WalletEntity;
import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletEntity,Long> {
    Optional<WalletEntity> findByCpfCnpjOrEmail(String cpfOrCnpj, String email);
}

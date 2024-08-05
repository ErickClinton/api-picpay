package tech.erick.picpay.module.tansfer;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.erick.picpay.module.tansfer.entity.TransferEntity;

import java.util.UUID;

public interface TransferRepository extends JpaRepository<TransferEntity, UUID> {
}

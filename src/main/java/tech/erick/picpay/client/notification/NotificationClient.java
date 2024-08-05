package tech.erick.picpay.client.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import tech.erick.picpay.module.tansfer.entity.TransferEntity;

@FeignClient(
        url = "${client.notification-service.url}"
)
public interface NotificationClient {
    @PostMapping
    ResponseEntity<Void> sendNotification(TransferEntity transferEntity);
}

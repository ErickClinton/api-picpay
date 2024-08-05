package tech.erick.picpay.client.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.erick.picpay.module.tansfer.entity.TransferEntity;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private final NotificationClient notificationClient;

    public NotificationService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }

    public void sendNotification(TransferEntity transferEntity){
        try {
            logger.info("Sending notification...");
            var resp = notificationClient.sendNotification(transferEntity);

            if(resp.getStatusCode().isError()){
                logger.error("Error while sending notification");
            }
        }catch (Exception e){
            logger.error("Error while sending notification ",e);
        }

    }
}

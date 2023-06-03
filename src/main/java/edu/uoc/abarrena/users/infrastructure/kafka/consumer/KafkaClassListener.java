package edu.uoc.abarrena.users.infrastructure.kafka.consumer;

import edu.uoc.abarrena.users.domain.model.Notification;
import edu.uoc.abarrena.users.domain.service.NotificationService;
import edu.uoc.abarrena.users.infrastructure.kafka.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaClassListener {

    private final NotificationService notificationService;

    public KafkaClassListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(
            topics = {
                    KafkaConstants.TRIPS_TOPIC + KafkaConstants.SEPARATOR + KafkaConstants.COMMAND_ADD
            },
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Notification notification) {
        notificationService.sendNotification(notification);
    }
}

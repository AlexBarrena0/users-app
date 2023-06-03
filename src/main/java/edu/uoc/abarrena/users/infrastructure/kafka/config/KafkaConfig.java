package edu.uoc.abarrena.users.infrastructure.kafka.config;

import edu.uoc.abarrena.users.domain.service.NotificationService;
import edu.uoc.abarrena.users.infrastructure.kafka.consumer.KafkaClassListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaClassListener kafkaClassListener(NotificationService notificationService) {
        return new KafkaClassListener(notificationService);
    }
}

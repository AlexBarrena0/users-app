package edu.uoc.abarrena.users.domain.service.impl;

import edu.uoc.abarrena.users.domain.model.FavouriteSearch;
import edu.uoc.abarrena.users.domain.model.Notification;
import edu.uoc.abarrena.users.domain.model.NotificationType;
import edu.uoc.abarrena.users.domain.service.FavouriteSearchService;
import edu.uoc.abarrena.users.domain.service.NotificationService;
import edu.uoc.abarrena.users.infrastructure.kafka.KafkaConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final KafkaTemplate<String, Notification> notificationKafkaTemplate;

    private final FavouriteSearchService favouriteSearchService;

    public NotificationServiceImpl(KafkaTemplate<String, Notification> notificationKafkaTemplate, FavouriteSearchService favouriteSearchService) {
        this.notificationKafkaTemplate = notificationKafkaTemplate;
        this.favouriteSearchService = favouriteSearchService;
    }

    @Override
    public void sendNotification(Notification notification) {
        if (notification.getType().equals(NotificationType.NEW_TRIP)) {
            HashMap<String, Object> params = notification.getParams();
            Long destinationId = Long.parseLong(params.get("destinationId").toString());
            LocalDate startDate = LocalDate.parse(params.get("startDate").toString());
            LocalDate endDate = LocalDate.parse(params.get("endDate").toString());
            FavouriteSearch favouriteSearch = new FavouriteSearch(startDate, endDate, destinationId);
            List<Long> usersIds = favouriteSearchService.findFavouriteSearchUsersByDestinationIdAndDates(favouriteSearch);
            if (usersIds.isEmpty()) {
                return;
            }
            usersIds.forEach(userId -> {
                Notification newNotification = new Notification(NotificationType.NEW_RESULT, userId);
                notificationKafkaTemplate.send(KafkaConstants.FAVOURITE_SEARCH_TOPIC + KafkaConstants.SEPARATOR + KafkaConstants.COMMAND_ADD, newNotification);
            });
        }
    }
}

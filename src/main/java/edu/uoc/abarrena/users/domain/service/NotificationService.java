package edu.uoc.abarrena.users.domain.service;

import edu.uoc.abarrena.users.domain.model.Notification;

public interface NotificationService {

    /**
     * Send a notification
     *
     * @param notification the notification to send
     */
    void sendNotification(Notification notification);
}

package com.first.twitter.services.notificationConfig.javaMail;

import com.first.twitter.exceptions.EmailMessageException;

public interface EmailSenderService {
    void sendEmail(String subject, String to, String email, String senderEmail) throws EmailMessageException;
}

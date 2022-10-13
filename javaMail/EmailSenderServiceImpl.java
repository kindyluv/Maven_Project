package com.first.twitter.services.notificationConfig.javaMail;

import com.first.twitter.exceptions.EmailMessageException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@AllArgsConstructor
@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailSenderServiceImpl.class);

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void sendEmail(String subject, String to, String email, String senderEmail) throws EmailMessageException {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom(senderEmail);
            mailSender.send(mimeMessage);
        }catch(MessagingException e){
            LOGGER.error("Failed to send email", e);
            throw new EmailMessageException("Failed to send email");
        }
    }
}

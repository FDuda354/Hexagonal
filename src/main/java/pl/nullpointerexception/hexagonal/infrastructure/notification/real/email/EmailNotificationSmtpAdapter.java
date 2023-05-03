package pl.nullpointerexception.hexagonal.infrastructure.notification.real.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import pl.nullpointerexception.hexagonal.infrastructure.notification.inmemory.email.EmailNotificationAdapter;

import java.util.List;

public class EmailNotificationSmtpAdapter implements EmailNotificationPort {

    private static Logger logger = LoggerFactory.getLogger(EmailNotificationAdapter.class);

    @Override
    public void send(List<String> recipients, String message) {
        logger.error("Brak konfiguracji SMTP");
    }
}

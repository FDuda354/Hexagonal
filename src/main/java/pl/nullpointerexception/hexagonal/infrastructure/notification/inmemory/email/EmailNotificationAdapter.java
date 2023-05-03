package pl.nullpointerexception.hexagonal.infrastructure.notification.inmemory.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;

import java.util.List;

public class EmailNotificationAdapter implements EmailNotificationPort {

    private static Logger logger = LoggerFactory.getLogger(EmailNotificationAdapter.class);

    @Override
    public void send(List<String> recipients, String message) {
        logger.info("Wysyłanie emaila inmmemory, message: " + message);
    }
}

package pl.nullpointerexception.hexagonal.infrastructure.notification.inmemory.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;

@Configuration
@Profile("mem")
public class EmailNotificationConfig {

    @Bean
    public EmailNotificationPort emailNotificationPort() {
        return new EmailNotificationAdapter();
    }
}

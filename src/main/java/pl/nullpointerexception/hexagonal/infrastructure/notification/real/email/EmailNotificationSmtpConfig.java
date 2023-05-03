package pl.nullpointerexception.hexagonal.infrastructure.notification.real.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import pl.nullpointerexception.hexagonal.domain.common.emailnotification.EmailNotificationPort;
import pl.nullpointerexception.hexagonal.infrastructure.notification.inmemory.email.EmailNotificationAdapter;

@Configuration
@Profile("!mem")
public class EmailNotificationSmtpConfig {

    @Bean
    public EmailNotificationPort emailNotificationPort() {
        return new EmailNotificationSmtpAdapter();
    }
}

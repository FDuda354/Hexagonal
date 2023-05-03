package pl.nullpointerexception.hexagonal.domain.common.emailnotification;

import java.util.List;

public interface EmailNotificationPort {

    void send(List<String> recipients, String message);
}

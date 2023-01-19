package dto;

import java.time.ZonedDateTime;
import java.util.Optional;

public class RequestDto {
    private Optional<String> userEmail;

    private Optional<ZonedDateTime> from;

    private Optional<ZonedDateTime> to;

    private Optional<String> resourceName;

    public Optional<String> getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(Optional<String> userEmail) {
        this.userEmail = userEmail;
    }

    public Optional<ZonedDateTime> getFrom() {
        return from;
    }

    public void setFrom(Optional<ZonedDateTime> from) {
        this.from = from;
    }

    public Optional<ZonedDateTime> getTo() {
        return to;
    }

    public void setTo(Optional<ZonedDateTime> to) {
        this.to = to;
    }

    public Optional<String> getResourceName() {
        return resourceName;
    }

    public void setResourceName(Optional<String> resourceName) {
        this.resourceName = resourceName;
    }




}

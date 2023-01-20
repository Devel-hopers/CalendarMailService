package dto;

import jakarta.mail.internet.InternetAddress;

import java.time.ZonedDateTime;

public class RequestDto {

    private InternetAddress userEmail;

    private ZonedDateTime from;

    private ZonedDateTime to;

    public InternetAddress getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(InternetAddress userEmail) {
        this.userEmail = userEmail;
    }

    public ZonedDateTime getFrom() {
        return from;
    }

    public void setFrom(ZonedDateTime from) {
        this.from = from;
    }

    public ZonedDateTime getTo() {
        return to;
    }

    public void setTo(ZonedDateTime to) {
        this.to = to;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    private String resourceName;

}

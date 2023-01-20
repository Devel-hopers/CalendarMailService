package service;

import dto.RequestOptionalDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

import java.io.IOException;

public interface BasicMailService {

    String sendSaveConfirm(RequestOptionalDto req) throws IOException, MessagingException;

    String sendDeletionAdvice(RequestOptionalDto req);

}

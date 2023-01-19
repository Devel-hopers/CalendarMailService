package service;

import dto.RequestDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import util.CheckRequest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
public class MailService implements BasicMailService{

    private static CheckRequest reqControl = CheckRequest.getInstance();
    private static JavaMailSenderImpl sender = new JavaMailSenderImpl();

    public String getTemplate() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("template.txt"));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        reader.close();
        return stringBuilder.toString();
    }
    private MimeMessageHelper buildBasics(RequestDto req) throws RuntimeException, MessagingException {
        RequestDto checkedReq = reqControl.check(req);
        sender.setHost("email_host");
        MimeMessage mess = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess);
        InternetAddress receiver = new InternetAddress(req.getUserEmail().get());
        helper.setTo(receiver);

        return helper;
    }

    @Override
    public String sendSaveConfirm(RequestDto req) {
        MimeMessageHelper mess;
        try {
            mess = this.buildBasics(req);
        } catch (MessagingException e) {
            throw new RuntimeException("Error occuredd while building basic email template");
        }

        return "";

    }

    @Override
    public String sendDeletionAdvice(RequestDto req) {
        MimeMessageHelper mess;
        try {
            mess = this.buildBasics(req);
        } catch (MessagingException e) {
            throw new RuntimeException("Error occuredd while building basic email template");
        }

        return "";

    }
}

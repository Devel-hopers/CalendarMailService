package service;

import dto.RequestDto;
import dto.RequestOptionalDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import util.CheckRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.ZonedDateTime;

@Service
public class MailService implements BasicMailService{

    private static CheckRequest reqControl = CheckRequest.getInstance();
    private static JavaMailSenderImpl sender = new JavaMailSenderImpl();

    // Get /template.txt (html/css) content as a string
    public StringBuilder getTemplate() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("template.txt"));
        String line = null;
        StringBuilder sheetBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            sheetBuilder.append(line);
            sheetBuilder.append(ls);
        }

        sheetBuilder.deleteCharAt(sheetBuilder.length() - 1);
        reader.close();
        return sheetBuilder;
    }

    // Build email basic components + style
    private MimeMessageHelper buildBasics(RequestDto req) throws RuntimeException, MessagingException {
        sender.setHost("email_host");
        MimeMessage mess = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mess);
        InternetAddress receiver = req.getUserEmail();
        helper.setTo(receiver);

        return helper;
    }

    @Override
    public String sendSaveConfirm(RequestOptionalDto raw_request) throws IOException, MessagingException {

        MimeMessageHelper mess;
        RequestDto req;
        try {
            req = reqControl.check(raw_request);
            mess = this.buildBasics(req);
        } catch (MessagingException e) {
            throw new RuntimeException("Error occuredd while building basic email template");
        }

        StringBuilder email_sb;
        email_sb = this.getTemplate();
        ZonedDateTime t = ZonedDateTime.now();

        int indexInternalBody = email_sb.lastIndexOf("{{internal-body-text{}");
        email_sb.replace(indexInternalBody-22, indexInternalBody, "Conferma di prenotazione");

        int indexBottomText = email_sb.lastIndexOf("{{botton-text}}");
        email_sb.replace(indexBottomText - 15, indexBottomText,
                    "Ciao! La risorsa " + req.getResourceName() +
                         " ti è stata riservata il " + req.getFrom());

        mess.setText(email_sb.toString());

        sender.send(mess.getMimeMessage());
        return email_sb.toString();

    }

    @Override
    public String sendDeletionAdvice(RequestOptionalDto raw_request) {

        MimeMessageHelper mess;
        RequestDto req;
        try {
            req = reqControl.check(raw_request);
            mess = this.buildBasics(req);
        } catch (MessagingException e) {
            throw new RuntimeException("Error occuredd while building basic email template");
        }

        return "";

    }
}

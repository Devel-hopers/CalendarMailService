package controller;

import dto.RequestOptionalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import service.MailService;

@Controller
public class RequestController {

    @Autowired
    MailService service;

    @PostMapping("/")
    public String sendConfirmation(@RequestHeader(value = "Confirmation") String type, @RequestBody RequestOptionalDto req ){
        return null;
    }

    @PostMapping("/")
    public String sendDeletionAdvice(@RequestHeader(value = "DeletionAdvice") String type, @RequestBody RequestOptionalDto req ){
        return null;
    }


}

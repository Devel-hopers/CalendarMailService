package controller;

import dto.RequestDto;
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
    public String sendConfirmation(@RequestHeader(value = "Confirmation") String type, @RequestBody RequestDto req ){
        return null;
    }

    @PostMapping("/")
    public String sendDeletionAdvice(@RequestHeader(value = "DeletionAdvice") String type, @RequestBody RequestDto req ){
        return null;
    }


}

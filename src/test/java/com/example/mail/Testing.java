package com.example.mail;

import org.junit.jupiter.api.Test;
import service.MailService;

import java.io.IOException;

public class Testing {
    MailService service = new MailService();

    @Test
    public void getHTML() throws IOException {
        System.out.println(service.getTemplate());
    }

}

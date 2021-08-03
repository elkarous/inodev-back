package com.brightcoding.app.ws.services.impl;

import com.brightcoding.app.ws.services.EmailService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;;

@Service("emailService")
public class EmailServiceImpl implements EmailService {

    public JavaMailSender mailSender;

    @Async
    public void sendEmail(SimpleMailMessage email) {
        mailSender.send(email);
    }
}

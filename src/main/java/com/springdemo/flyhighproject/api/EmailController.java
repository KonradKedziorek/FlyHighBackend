package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.model.Email;
import com.springdemo.flyhighproject.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;


@RestController
@RequestMapping("/")
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/resetPassword")
    public void sendEmailToResetPassword(@RequestBody Email email){
        emailService.sendEmailToResetPassword(email.getEmail());
    }
}

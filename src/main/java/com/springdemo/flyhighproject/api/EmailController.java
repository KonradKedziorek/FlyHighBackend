package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.model.Email;
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
    private JavaMailSender javaMailSender;

    @CrossOrigin
    @PostMapping("/resetPassword")
    void sendEmail(@RequestBody Email email) {

        System.out.println("email: " + email);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email.getEmail());

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Twoje tymczasowe hasło: xyz.\nFly High Corporation" );

        System.out.println("Sending Email...");
        System.out.println(msg);
        javaMailSender.send(msg);
        System.out.println("Done");
    }

    void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("1@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
}

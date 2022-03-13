package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Account;
import com.springdemo.flyhighproject.model.Email;
import com.springdemo.flyhighproject.repo.AccountRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Service
public class EmailService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    void sendEmailToResetPassword(String email) {
        Account account = accountRepository.findByEmail(email);
        String token = RandomString.make(45);

        if(account != null){
            accountService.updateResetPasswordToken(token, account);

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(email);

            msg.setSubject("Fly High Password Reset");
            msg.setText("link/stronaDoWpisaniaHaslaNowego?token=" + token);

            System.out.println("Sending Email...");
            System.out.println(msg);
            javaMailSender.send(msg);
            System.out.println("Done");
        }

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

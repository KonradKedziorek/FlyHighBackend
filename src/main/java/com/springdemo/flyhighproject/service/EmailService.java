package com.springdemo.flyhighproject.service;

import com.springdemo.flyhighproject.model.Account;
import com.springdemo.flyhighproject.model.Email;
import com.springdemo.flyhighproject.model.Flight;
import com.springdemo.flyhighproject.repo.AccountRepository;
import com.springdemo.flyhighproject.repo.FlightRepository;
import lombok.extern.flogger.Flogger;
import lombok.extern.java.Log;
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
import java.io.Console;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class EmailService {

    private final static Logger LOGGER = Logger.getLogger(EmailService.class.getName());

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private FlightRepository flightRepository;

    public void sendMail(SimpleMailMessage msg) {
        if(msg != null){
            javaMailSender.send(msg);
            LOGGER.info("Mail has been send");
        }else LOGGER.info("Failed to send mail, no account with this email");
    }

    public void sendMailToGroup(List<SimpleMailMessage> msgs) {
        if(msgs != null){
            for(SimpleMailMessage msg : msgs){
                javaMailSender.send(msg);
                LOGGER.info("Mails has been send");
            }
        }else LOGGER.info("Failed to send mails, no account with this email");
    }

    public SimpleMailMessage prepareMailToResetPassword(String email){
        Account account = accountRepository.findByEmail(email);

        if(account != null){
            String token = RandomString.make(45);
            accountService.updateResetPasswordToken(token, account);

            SimpleMailMessage msg = new SimpleMailMessage();
            msg.setTo(email);

            msg.setSubject("Fly High Password Reset");
            msg.setText("link/stronaDoWpisaniaHaslaNowego?token=" + token);

            return msg;
        }else LOGGER.info("No account has been found");
        return null;
    }

    public List<SimpleMailMessage> prepareMailsAboutCancellation(List<String> emails){
        List<SimpleMailMessage> msgs = null;

        if(!emails.isEmpty()){
            for(String email : emails){
                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo(email);

                msg.setSubject("Flight cancellation");
                msg.setText("We are very sorry to inform You, that your flight has been cancelled.");
                msgs.add(msg);
            }
            return msgs;
        }else LOGGER.info("There's no passengers for that flight.");
        return null;
    }

    public SimpleMailMessage prepareMailAboutReservation(String email, long flightId){

        Flight flight = flightRepository.findById(flightId);
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(email);
        msg.setSubject("Fly High Ticket Reservation");
        msg.setText("You have successfully made a reservation for a flight with details listed below: \n" +
                "Flight Origin: " + flight.getTakeOffAirport().getName() + "(" + flight.getTakeOffAirport().getCity() + ", " + flight.getTakeOffAirport().getCountry() + ") \n" +
                "Flight Destination: " + flight.getTouchdownAirport().getName() + "(" + flight.getTouchdownAirport().getCity() + ", " + flight.getTouchdownAirport().getCountry() + ") \n" +
                "Flight take off date and time: " + flight.getTakeOffDate().getHour() + ":" + flight.getTakeOffDate().getMinute() + "\n\n" +
                "Please, pay the fee within 12 hours or your reservation will be cancelled.\n" +
                "FlyHigh Corporation");

        return msg;
    }

    public void sendEmailWithAttachment() throws MessagingException, IOException {

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

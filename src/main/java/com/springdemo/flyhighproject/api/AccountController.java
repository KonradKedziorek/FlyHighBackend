package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.config.SecurityConfig;
import com.springdemo.flyhighproject.model.Account;
import com.springdemo.flyhighproject.payload.EditDataRequest;
import com.springdemo.flyhighproject.payload.ResetPasswordRequest;
import com.springdemo.flyhighproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/newPassword")
    public void updatePassword(@RequestParam(name = "token") String token, @RequestBody ResetPasswordRequest resetPasswordRequest){
        System.out.println("Token: " + token);
        System.out.println("Password: " + resetPasswordRequest);
        accountService.updatePassword(token, resetPasswordRequest.getNewPassword(), resetPasswordRequest.getRepeatedNewPassword());
    }

    @GetMapping("/EditPersonalData")
    public void updatePersonalData(){
        SecurityContextHolder.getContext().getAuthentication().getName();
//        EditDataRequest editDataRequest = new EditDataRequest(account.getUser().getName(), account.getUser().getMiddleName(),
//                account.getUser().getSurname(),account.getUser().getAddress().getCountry(),account.getUser().getAddress().getCity(),
//                account.getUser().getAddress().getStreet(), account.getEmail(), account.getPhoneNumber(),
//                account.getUser().getAddress().getHouseNumber(), account.getUser().getAddress().getZipCode(), account.getUser().getBankAccount());
//        return editDataRequest;
        return ;
    }

}

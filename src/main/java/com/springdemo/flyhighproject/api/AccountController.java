package com.springdemo.flyhighproject.api;

import com.springdemo.flyhighproject.payload.ResetPasswordRequest;
import com.springdemo.flyhighproject.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
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
}

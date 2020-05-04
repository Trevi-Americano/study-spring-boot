package com.serenity;

import com.serenity.account.Account;
import com.serenity.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AccountRunner implements ApplicationRunner {
    @Autowired
    private AccountService accountService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
           Account serenity = accountService.createAccount("serenity", "1234");
           System.out.println("username: " + serenity.getUsername() + ", password: " + serenity.getPassword());
    }
}

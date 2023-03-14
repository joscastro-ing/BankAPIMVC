package com.bankapi.bankapi.Controller;

import org.springframework.web.bind.annotation.*;

import com.bankapi.bankapi.Model.Account;
import com.bankapi.bankapi.services.AccountService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    public AccountService accountService;
    

    @GetMapping()
    public ArrayList<Account> getAccounts(){
        return accountService.getAccounts();
    }

    @PostMapping()
    public Account saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }
    @GetMapping(path= "/{number}")
    public Optional<Account> findAccount(@PathVariable Long number){
        return  accountService.findAccount(number);
    }

    @GetMapping(path = "/type")
    public ArrayList<Account> findByTypeAccount(@PathVariable String type){
        return accountService.findByTypeAccount(type);
    }
    

}

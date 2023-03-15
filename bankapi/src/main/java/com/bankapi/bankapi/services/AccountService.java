package com.bankapi.bankapi.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapi.bankapi.Model.Account;
import com.bankapi.bankapi.Repositories.AccountRepository;
import com.bankapi.bankapi.Repositories.TypeAccountRepository;

@Service
public class AccountService {
    @Autowired
    public AccountRepository accountRepository;
    @Autowired
    public TypeAccountRepository typeAccountRepository;

    public ArrayList<Account> getAccounts(){
        return (ArrayList<Account>) accountRepository.findAll();
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public Optional<Account> findAccount(Long number){
        return  accountRepository.findById(number);
    }

    public ArrayList<Account> findByTypeAccount(String type){
        return (ArrayList<Account>) accountRepository.findByType(typeAccountRepository.findByType(type));

    }

    public void deposite(Account account, double amount){
        account.setBalance(amount + account.getBalance());
        accountRepository.save(account);
    }

    public boolean removeMoney(Account account, double amount){
        if(account.getBalance() < amount){
            return false;
        } else{
            account.setBalance(account.getBalance()-amount);
            accountRepository.save(account);
            return true;
        }
    }

    public void remove(Account account) {
         accountRepository.delete(account);
    }

    public void removeById(long id) {
        accountRepository.deleteById(id);
    }
}

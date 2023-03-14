package com.bankapi.bankapi.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapi.bankapi.Model.User;
import com.bankapi.bankapi.Repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;

    public ArrayList<User> getUsers() {
        return (ArrayList<User>) this.userRepository.findAll();
    }

    public User saveUser(User user) {
        return this.userRepository.save(user);
    }

    public boolean DeleteById(Integer id) {
        try {
            this.userRepository.deleteById(id);
            return true;

        } catch (Error e) {
            return false;
        }
    }

}

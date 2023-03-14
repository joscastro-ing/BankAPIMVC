package com.bankapi.bankapi.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bankapi.bankapi.services.UserService;
import com.bankapi.bankapi.Model.User;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping()
    public ArrayList<User> getUsers(){
        return userService.getUsers();
    }
    @PostMapping()
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @DeleteMapping(path ="/{id}")
    public String DeleteById (@PathVariable Integer id){
        boolean ok = userService.DeleteById(id);
        if(ok){
            return "Se elimino el usuario con el id" + id;
        }else{
            return "Error al eliminar el usuario con el id" + id;
        }
    }
}

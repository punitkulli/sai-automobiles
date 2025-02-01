package com.SAI.stock.controlllers;

import com.SAI.stock.dtoModules.User;
import com.SAI.stock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create")
    public ResponseEntity createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping(value = "/update")
    public ResponseEntity updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @GetMapping(value = "/getAllUsers")
    public ResponseEntity getAllUsers() {
        return userService.getAllUser();
    }

}

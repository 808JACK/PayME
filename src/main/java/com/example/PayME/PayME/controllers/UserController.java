package com.example.PayME.PayME.controllers;


import com.example.PayME.PayME.dtos.UserDTO;
import com.example.PayME.PayME.services.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody  UserDTO userDTO){
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userService.findUserById(userId));
    }



}

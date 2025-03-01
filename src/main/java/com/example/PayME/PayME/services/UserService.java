package com.example.PayME.PayME.services;

import com.example.PayME.PayME.dtos.UserDTO;

public interface UserService {

    UserDTO saveUser(UserDTO userDTO);

    UserDTO findUserById(Long userDTO);
}

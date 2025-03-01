package com.example.PayME.PayME.services;

import com.example.PayME.PayME.dtos.UserDTO;
import com.example.PayME.PayME.entities.UserEntity;
import com.example.PayME.PayME.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        return modelMapper.map(userRepo.save(userEntity), UserDTO.class);
    }

    @Override
    public UserDTO findUserById(Long userId) {
        return modelMapper.map(userRepo.findById(userId), UserDTO.class);
    }


}

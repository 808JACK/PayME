package com.example.PayME.PayME.services;


import com.example.PayME.PayME.dtos.GroupDTO;
import com.example.PayME.PayME.entities.GroupEntity;
import com.example.PayME.PayME.entities.UserEntity;
import com.example.PayME.PayME.exceptions.ResourceNotFoundException;
import com.example.PayME.PayME.repos.GroupRepo;
import com.example.PayME.PayME.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService{

    private final GroupRepo groupRepo;
    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    @Override
    public GroupDTO saveGroup(GroupDTO groupDTO) {
        GroupEntity groupEntity = modelMapper.map(groupDTO,GroupEntity.class);
        return modelMapper.map(groupRepo.save(groupEntity),GroupDTO.class);
    }

    @Override
    public GroupDTO findGroupById(Long groupId) {
        GroupEntity groupEntity = groupRepo.findById(groupId).orElse(null);
        return modelMapper.map(groupEntity, GroupDTO.class);
    }

    @Override
    public GroupDTO addUserToGroup(Long groupId, Long userId) {
        GroupEntity groupEntity = groupRepo.findById(groupId).orElseThrow(() -> new RuntimeException("group not found"));
        UserEntity userEntity = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user not found "));

        groupEntity.addUser(userEntity);
        groupRepo.save(groupEntity);
        return modelMapper.map(groupEntity,GroupDTO.class);
    }

}

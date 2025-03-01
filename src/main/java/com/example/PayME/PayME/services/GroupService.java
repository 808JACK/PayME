package com.example.PayME.PayME.services;

import com.example.PayME.PayME.dtos.GroupDTO;

public interface GroupService {

    GroupDTO saveGroup(GroupDTO groupDTO);

    GroupDTO findGroupById(Long groupId);

    GroupDTO addUserToGroup(Long groupId, Long userId);
}

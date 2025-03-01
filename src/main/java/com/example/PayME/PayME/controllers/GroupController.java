package com.example.PayME.PayME.controllers;

import com.example.PayME.PayME.dtos.GroupDTO;
import com.example.PayME.PayME.repos.UserRepo;
import com.example.PayME.PayME.services.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<GroupDTO> saveGroup(@RequestBody GroupDTO groupDTO){
        return ResponseEntity.ok(groupService.saveGroup(groupDTO));
    }

    @GetMapping("/{groupId}")
    public ResponseEntity<GroupDTO> findGroupById(@PathVariable Long groupId){
        return ResponseEntity.ok(groupService.findGroupById(groupId));
    }

    @PostMapping("/{groupId}/users/{userId}")
    public ResponseEntity<GroupDTO> addUserToGroup(
            @PathVariable Long groupId,
            @PathVariable Long userId
    )
    {
        return ResponseEntity.ok(groupService.addUserToGroup(groupId,userId));
    }

}

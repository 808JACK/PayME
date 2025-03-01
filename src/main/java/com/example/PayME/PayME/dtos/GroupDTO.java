package com.example.PayME.PayME.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Getter
@Setter
public class GroupDTO {

    private Long id;
    private String groupName;
    private LocalDateTime createdAt;
    private List<UserDTO> users;
}

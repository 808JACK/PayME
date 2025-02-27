package com.example.PayME.PayME.dtos;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String password;
}

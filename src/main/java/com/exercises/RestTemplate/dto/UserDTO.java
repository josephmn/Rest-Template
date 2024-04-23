package com.exercises.RestTemplate.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private String email;
    private String address;
    private boolean status;
}

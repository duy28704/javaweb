package com.example.laptopshop.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String password;
    private String confirmPassword;
    private String email;
}

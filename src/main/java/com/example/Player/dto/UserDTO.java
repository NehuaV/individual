package com.example.Player.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    // No password cause security reasons lmao
}

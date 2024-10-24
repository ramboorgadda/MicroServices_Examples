package com.springboot.blog.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginDto {

    private String usernameOrEmail;
    private String password;
}

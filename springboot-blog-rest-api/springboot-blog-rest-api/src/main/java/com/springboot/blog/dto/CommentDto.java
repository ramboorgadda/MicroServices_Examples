package com.springboot.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CommentDto {

    private long id;
    @NotEmpty
    @Size(min = 10,message = "Comments body minimum 10 characters")
    private String body;
    @NotEmpty(message = "email should not be null or empty")
    @Email
    private String email;
    @NotEmpty(message = "name should not be null or empty")
    private String name;

}

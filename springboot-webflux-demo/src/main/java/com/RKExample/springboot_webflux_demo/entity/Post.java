package com.RKExample.springboot_webflux_demo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Post {

    @Id
    private String id;
    private String title;
    private String description;
    private String body;
    @Field(name ="created_on")
    private LocalDateTime createdOn;
    @Field(name ="updated_on")
    private LocalDateTime updatedOn;

}

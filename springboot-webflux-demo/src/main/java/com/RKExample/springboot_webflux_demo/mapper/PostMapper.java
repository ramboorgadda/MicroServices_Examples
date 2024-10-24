package com.RKExample.springboot_webflux_demo.mapper;

import com.RKExample.springboot_webflux_demo.dto.PostDto;
import com.RKExample.springboot_webflux_demo.entity.Post;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PostMapper {

    public Post mapToPost(PostDto postDto){
        return Post.builder().
                title(postDto.getTitle())
                .description(postDto.getDescription())
                .body(postDto.getBody()).build();
    }

    public PostDto mapToPost(Post post){
        return PostDto.builder().
                title(post.getTitle())
                .description(post.getDescription())
                .body(post.getBody()).build();
    }
}

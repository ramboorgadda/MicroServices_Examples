package com.RKExample.springboot_webflux_demo.service.impl;

import com.RKExample.springboot_webflux_demo.dto.PostDto;
import com.RKExample.springboot_webflux_demo.entity.Post;
import com.RKExample.springboot_webflux_demo.mapper.PostMapper;
import com.RKExample.springboot_webflux_demo.repository.PostReactiveRepository;
import com.RKExample.springboot_webflux_demo.service.PostService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public class PostServiceImpl implements PostService {

    private PostReactiveRepository postReactiveRepository;
    private PostMapper postMapper;


    @Override
    public Post save(PostDto postDto) {

        Post post = postMapper.mapToPost(postDto);
        post.setCreatedOn(LocalDateTime.now());
        post.setUpdatedOn(LocalDateTime.now());
        postReactiveRepository.save(post).map(p ->{
            postDto.setId(p.getId());
            return postDto;
        });

        return post;
    }

    @Override
    public Flux<PostDto> findAllPosts() {
        return null;
    }

    @Override
    public Mono<PostDto> update(PostDto postDto, String id) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}

package com.RKExample.springboot_webflux_demo.service;

import com.RKExample.springboot_webflux_demo.dto.PostDto;
import com.RKExample.springboot_webflux_demo.entity.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PostService {

    Post save(PostDto postDto);

    Flux<PostDto> findAllPosts();

    Mono<PostDto> update(PostDto postDto,String id);

    Mono<Void> delete(String id);
}

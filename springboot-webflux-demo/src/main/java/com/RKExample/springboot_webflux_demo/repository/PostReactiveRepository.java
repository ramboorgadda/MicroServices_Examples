package com.RKExample.springboot_webflux_demo.repository;

import com.RKExample.springboot_webflux_demo.entity.Post;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PostReactiveRepository extends ReactiveCrudRepository<Post,String> {
    Mono<Boolean> existsByTitle(String title);
}

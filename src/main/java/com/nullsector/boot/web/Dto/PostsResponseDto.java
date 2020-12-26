package com.nullsector.boot.web.Dto;

import com.nullsector.boot.domain.posts.Posts;
import lombok.Getter;

/**
* <pre>
* com.nullsector.boot.web.Dto
* ㄴ PostsResponseDto.java
* </pre>
* @date : 2020-12-23 오후 5:57
* @author : nullsector12/김승연
* @version : 1.0.0
* @see:
**/
@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
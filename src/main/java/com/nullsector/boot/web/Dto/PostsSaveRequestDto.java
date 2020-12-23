package com.nullsector.boot.web.Dto;

import com.nullsector.boot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


/**
* <pre>
* com.nullsector.boot.web.Dto
* ㄴ PostsSaveRequestDto.java
* </pre>
* @date : 2020-12-23 오후 5:42
* @author : nullsector12/김승연
* @version : 1.0.0
* @see:
**/
@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;



    /**
    *
    * @methodName : PostsSaveRequestDto
    * @author : nullsector12/김승연
    * @date : 2020-12-23 오후 7:09
    * @returnType :
    * @parameter : [title, content, author]
    * @comment :
    **/
    @Builder
    public PostsSaveRequestDto (String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {

        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();

    }

}

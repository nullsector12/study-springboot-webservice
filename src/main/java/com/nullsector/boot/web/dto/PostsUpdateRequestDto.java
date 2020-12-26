package com.nullsector.boot.web.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
* <pre>
* com.nullsector.boot.web.Dto
* ㄴ PostsUpdateRequestDto.java
* </pre>
* @date : 2020-12-23 오후 6:00
* @author : nullsector12/김승연
* @version : 1.0.0
* @see:
**/
@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {

    private String title;
    private String content;


    /**
    *
    * @methodName : PostsUpdateRequestDto
    * @author : nullsector12/김승연
    * @date : 2020-12-23 오후 7:09
    * @returnType :
    * @parameter : [title, content]
    * @comment :
    **/
    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }


}

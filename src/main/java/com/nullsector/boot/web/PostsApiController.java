package com.nullsector.boot.web;


import com.nullsector.boot.service.posts.PostsService;
import com.nullsector.boot.web.Dto.PostsResponseDto;
import com.nullsector.boot.web.Dto.PostsSaveRequestDto;
import com.nullsector.boot.web.Dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
* <pre>
* com.nullsector.boot.web
* ㄴ PostsApiController.java
* </pre>
* @date : 2020-12-23 오후 5:34
* @author : nullsector12/김승연
* @version : 1.0.0
* @see:
**/

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;




    /**
    *
    * @methodName : save
    * @author : nullsector12/김승연
    * @date : 2020-12-23 오후 7:10
    * @returnType : java.lang.Long
    * @parameter : [requestDto]
    * @comment :
    **/
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }


    /**
    *
    * @methodName : update
    * @author : nullsector12/김승연
    * @date : 2020-12-23 오후 7:11
    * @returnType : java.lang.Long
    * @parameter : [id, requestDto]
    * @comment :
    **/
    @PutMapping("/api/v1/posts/{id}")
    public Long update (@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }


    /**
    *
    * @methodName : findById
    * @author : nullsector12/김승연
    * @date : 2020-12-23 오후 7:12
    * @returnType : com.nullsector.boot.web.Dto.PostsResponseDto
    * @parameter : [id]
    * @comment :
    **/
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

}

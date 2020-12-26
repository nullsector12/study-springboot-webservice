package com.nullsector.boot.web;

import com.nullsector.boot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
* <pre>
* com.nullsector.boot.web
* ㄴ HelloController.java
* </pre>
* @date : 2020-12-21 오후 6:10
* @author : nullsector12/김승연
* @version : 1.0.1
* @see: 2020-12-21 오후 6:55 lombok 을 사용하는 Controller 로 변환
**/

// 컨트롤러를 JSON 을 반환하는 컨트롤러로 만들어줌
// 예전에는 @ResponseBody 를 각 메소드마다 선언했던 것을
// 한번에 사용할 수 있게 해준다 생각
@RestController
public class HelloController {
    /**
    *
    * @methodName : hello
    * @author : nullsector12/김승연
    * @date : 2020-12-21 오후 6:12
    * @returnType : java.lang.String
    * @parameter :
    * @comment :
    **/

    // HTTP Method 인 GET 의 요청을 받을 수 있는 API 만들어줌
    // 예전엔 @RequestMapping(method = RequestMethod.GET)으로 사용하던 것
    // 이제 이 프로젝트는 /hello 로 요청이 오면 문자열 hello 를 반환
    @GetMapping("/hello/dto")

    // @RequestParam
    // 외부에서 API 로 넘긴 파라미터를 가져오는 어노테이션
    // 여기서는 외부에서 name(@RequestParam("name'))이란 이름으로 넘긴 파라미터를
    // 메소드 파라미터 name(String name)에 저장함
    // amount 도 마찬가지
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount){

        return new HelloResponseDto(name, amount);
    }

}

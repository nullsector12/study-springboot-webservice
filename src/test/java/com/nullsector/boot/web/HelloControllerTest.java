package com.nullsector.boot.web;

import com.nullsector.boot.config.auth.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
* <pre>
* com.nullsector.boot.web
* ㄴ HelloControllerTest.java
* </pre>
* @date : 2020-12-21 오후 6:17
* @author : nullsector12/김승연
* @version : 1.0.1
* @see: 2020-12-21 오후 7:00 lombok 을 이용한 Controller Test
**/
// 테스트를 진행할 때 JUnit 에 내장된 실행자 외에 다른 실행자를 실행
// 여기서는 SpringRunner 라는 스프링 실행자 실행
// 즉, 스프링 부트 테스트와 JUnit 사이의 연결자 역할
@ExtendWith(SpringExtension.class)
// 여러 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
// 선언할 경우 @Controller, @ControllerAdvice 등을 사용 가능
// 여기서는 컨트롤러만 사용하기 때문에 선언함
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
public class HelloControllerTest {

    // 스프링 컨테이너가 관리하는 bean 주입받음
    @Autowired
    // MockMvc
    // 웹 API 테스트할 때 사용
    // 스프링 MVC 의 시작점
    // 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능
    private MockMvc mvc;
 // test1111222
    /**
    *
    * @methodName : returnToHello
    * @author : nullsector12/김승연
    * @date : 2020-12-21 오후 6:18
    * @returnType : void
    * @parameter :
    * @comment :
    **/
    @WithMockUser(roles = "USER")
    @Test
    public void returnToHello() throws Exception {
        String hello = "Hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청
        // 체이닝이 지원되어 아래와 같이 여러 검증기능 이어서 선언 가능
        mvc.perform(get("/hello"))

                // mvc.perform 의 결과 검증
                // HTTP Header 의 Status 검증
                // 흔히 알고있는 200, 404, 500 등 상태 검증
                // 여기선 Ok 즉, 200인지 아닌지 검증
                .andExpect(status().isOk())

                // mvc.perform 의 결과 검증
                // 응답 본문의 내용 검증
                // Controller 에서 "Hello!" 를 리턴하기 때문에 이 값이 맞는지 검증
                .andExpect(content().string(hello));
    }

    @WithMockUser(roles = "USER")
    @Test
    public void returnToHelloDto() throws Exception {
        String name = "hello";
        int amount = 1000;

        // param
        // API 테스트할 때 사용될 요청 파라미터 설정
        // 단 값은 String 만 허용
        // 그래서 숫자, 날짜 등의 데이터도 등록할 때는 문자열로 변경해야 가능
        mvc.perform(get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())

                // jsonPath
                // JSON 응답값을 필드별로 검증할 수 있는 메소드
                // $를 기준으로 필드명 명시
                // 여기서는 name 과 amount 를 검증하니 $.name, $.amount 검증
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}

package com.nullsector.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
* <pre>
* com.nullsector.boot
* ㄴ Application.java
* </pre>
* @date : 2020-12-21 오후 5:56
* @author : nullsector12/김승연
* @version : 1.0.0
* @see:
**/
// Test를 위해 SpringBootApplication과 분리함 -> config 패키지의 JpaConfig로 이동
//@EnableJpaAuditing // JPA Auditing 활성화 어노테이션
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        // 내장 WAS를 실행
        // 톰캣을 설치할 필요없이 jar 파일로 실행하면 됨.
        SpringApplication.run(Application.class, args);
    }
}

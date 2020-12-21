package com.nullsector.boot.web.Dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
* <pre>
* com.nullsector.boot.web.Dto
* ㄴ HelloResponseDto.java
* </pre>
* @date : 2020-12-21 오후 6:43
* @author : nullsector12/김승연
* @version : 1.0.0
* @see:
**/
// 선언된 모든 필드의 get 메소드를 생성(lombok)
@Getter
// 선언된 모든 final 필드가 포함된 생성자 생성(lombok)
// final 이 없는 필드는 생성자 생성 안함
@RequiredArgsConstructor
public class HelloResponseDto {

    private final String name;
    private final int amount;

}

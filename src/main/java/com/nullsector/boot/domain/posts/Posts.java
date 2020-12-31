package com.nullsector.boot.domain.posts;

import com.nullsector.boot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
* <pre>
* com.nullsector.boot.domain.posts
* ㄴ Posts.java
* </pre>
* @date : 2020-12-23 오후 4:49
* @author : nullsector12/김승연
* @version : 1.0.0
* @see:
**/

// 클래스 내 모든 필드의 Getter 메소드 자동 생성
@Getter // lombok 어노테이션
/** NoArgsConstructor
 * 기본 생성자 자동 추가
 * == public Posts(){}
 */
@NoArgsConstructor // lombok 어노테이션
/** Entity
 * 테이블과 링크될 클래스임을 나타냄
 * 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
 * ex) SalesManager.java -> sales_manager table
 *
 * **/
@Entity // JPA 어노테이션
public class Posts extends BaseTimeEntity {

    /** Id
     * 해당 테이블의 PK 필드를 나타냄
     */
    @Id // JPA 어노테이션
    /** GeneratedValue
     * PK 의 생성규칙을 나타냄
     * 스프링 부트 2.0 에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto_increment 가 됨
     * 스프링 부트 2.0과 1.5에서의 차이는 https://jojoldu.tistory.com/295
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY) // JPA 어노테이션
    private Long id;

    /** Column
     * 테이블의 칼럼을 나타맴, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 되긴함
     * 사용하는 이유 : 기본값 외에 추가로 변경이 필요한 옵션이 있을 때 사용
     * 문자열의 경우 VARCHAR(255)가 기본값인데, 사이즈를 500으로 늘리고 싶거나(ex:title),
     * 타입을 TEXT 로 변경하고 싶거나(ex:content)등의 경우
     */
    @Column(length = 500, nullable = false) // JPA 어노테이션
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // JPA 어노테이션
    private String content;

    private String author;


    /** Builder
     * 해당 클래스의 빌더 패던 클래스 생성
     * 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    *
    * @methodName : Posts
    * @author : nullsector12/김승연
    * @date : 2020-12-23 오후 7:08
    * @returnType :
    * @parameter : [title, content, author]
    * @comment :
    **/
    @Builder // lombok 어노테이션
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update (String title, String content){
        this.title = title;
        this.content = content;
    }
}

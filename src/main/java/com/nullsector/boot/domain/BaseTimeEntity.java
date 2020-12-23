package com.nullsector.boot.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
* <pre>
* com.nullsector.boot.domain
* ㄴ BaseTimeEntity.java
* </pre>
* @date : 2020-12-23 오후 7:45
* @author : nullsector12/김승연
* @version : 1.0.0
* @see: 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리
**/

@Getter
/** MappedSuperclass
 * JPA Entity 클래스들이 BaseTimeEntity 를 상속할 경우 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 함
 */
@MappedSuperclass
/** EntityListeners(AuditingEntityListener.class)
 * BaseTimeEntity 클래스에 Auditing 기능을 포함시킨다.
 */
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    /** CreatedDate
     * Entity 가 생성돠어 저장될 때 시간이 자동 저장
     */
    @CreatedDate
    private LocalDateTime createdDate;

    /** LastModifiedDate
     * 조회한 Entity 의 값을 변경할 때 시간이 자동 저장
     */
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}

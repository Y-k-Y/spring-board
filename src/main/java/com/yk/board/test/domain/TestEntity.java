package com.yk.board.test.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
// 무분별한 setter 메소드의 추가보단 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가하자.
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String email;

    private  String name;

    @CreationTimestamp
    private Timestamp regDate;

    @UpdateTimestamp
    private Timestamp updateDate;

    @Builder
    public TestEntity(String email, String name){

        this.email = email;
        this.name = name;
    }

    public void updateName(String name) {

        this.name = name;
    }
}

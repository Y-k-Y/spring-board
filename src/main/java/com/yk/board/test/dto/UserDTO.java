package com.yk.board.test.dto;

import com.yk.board.test.domain.TestEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private String email;
    private String name;

    @Builder
    public UserDTO(String email, String name){

        this.email = email;
        this.name = name;
    }

    public TestEntity toEntity() {

        return TestEntity.builder()
                .email(email)
                .name(name)
                .build();
    }
}
package com.yk.board.test.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
@Getter
@Setter
public class TestEntity {

    @Id
    private @Column(name = "id") Long id;
    private @Column(name = "email") String email;
    private @Column(name = "name") String name;
}

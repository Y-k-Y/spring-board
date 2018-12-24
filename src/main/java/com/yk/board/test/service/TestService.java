package com.yk.board.test.service;

import com.yk.board.test.entity.TestEntity;

import java.util.Optional;

public interface TestService {

    public TestEntity allUsers(Long id);

    public String findUserNameByEmail(String email);
}
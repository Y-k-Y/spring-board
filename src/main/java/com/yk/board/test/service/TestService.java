package com.yk.board.test.service;

import com.yk.board.test.domain.TestEntity;

import java.util.List;

public interface TestService {

    public List<TestEntity> allUsers();

    public String findUserNameByEmail(String email);

    public void deleteUserByEmail(String email);

    public void updateUserName(Long id, String newName);
}
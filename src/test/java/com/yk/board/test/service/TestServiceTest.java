package com.yk.board.test.service;

import com.yk.board.test.domain.TestEntity;
import com.yk.board.test.repository.TestRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestServiceTest {

    @Autowired
    TestService testService;

    @Autowired
    TestRepository testRepository;

    @Test
    public void deleteUser(){

        // given
        String email = "Zzzzz.co.kr@gmail.com ...18";

        // when
        testService.deleteUserByEmail(email);

        // then
        List<TestEntity> list = testRepository.findAll();
        assertThat(list.size(), is(17));
    }

    @Test
    @Transactional
    // service layer에서 끝난 trasaction을 참조하려고 해서 LazyInitializationException이 발생한다?
    public void updateUserName(){

        // given
        String newName = "YK";
        Long id = 17L;

        // when
        testService.updateUserName(id, newName);

        // then
        TestEntity testEntity = testRepository.getOne(id);
        assertThat(testEntity.getName(), is(newName));
    }
}

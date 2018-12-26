package com.yk.board.test;

import com.yk.board.test.domain.TestEntity;
import com.yk.board.test.repository.TestRepository;
import com.yk.board.test.service.TestService;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {

    @Autowired
    private TestService testService;

    @Autowired
    private TestRepository testRepository;


    /*@After
    public void cleanup(){

        testRepository.deleteAll();
    }*/

    @Test
    public void insertUser(){

        // given
        for(int i = 1; i < 101; i++)
        testRepository.save(TestEntity.builder()
                .email("Zzzzz.co.kr@gmail.com ..." + i)
                .name("윤여경 ..." + i)
                .build());

        // when
        List<TestEntity> list = testRepository.findAll();

        // then
        assertThat(list.size(), is(100));
    }

    @Test
    public void getAllUsers(){

        // given
        List<TestEntity> list = testRepository.findAll();

        // when
        TestEntity testEntity = list.get(0);

        // then
        assertThat(testEntity.getEmail(), is("Zzzzz.co.kr@gmail.com"));
        assertThat(testEntity.getName(), is("YK"));
    }

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
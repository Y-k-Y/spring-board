package com.yk.board.test.repository;

import com.yk.board.test.domain.TestEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRepositoryTest {

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
}

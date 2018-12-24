package com.yk.board.test;

import com.yk.board.test.entity.TestEntity;
import com.yk.board.test.repository.TestRepository;
import com.yk.board.test.service.TestService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test2 {

    @Autowired
    private TestService testService;

    @Autowired
    private TestRepository testRepository;

    /*@After
    public void cleanup(){


    }*/

    @org.junit.Test
    public void allUsers(){

        TestEntity list = testService.allUsers(1L);
        System.out.println(list.getEmail());
    }




}

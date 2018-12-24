package com.yk.board.Controller;

import com.yk.board.test.entity.TestEntity;
import com.yk.board.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/test")
    public String test(){

        TestEntity testEntity = testService.allUsers(1L);
        String email = testEntity.getEmail();
        return email;
    }

}
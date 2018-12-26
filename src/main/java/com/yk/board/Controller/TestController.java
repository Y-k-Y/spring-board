package com.yk.board.Controller;

import com.yk.board.test.domain.TestEntity;
import com.yk.board.test.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Api(value = "TestController", description = "test api", basePath = "/test")
public class TestController {

    TestService testService;

    @GetMapping("/user/all")
    @ApiOperation(value = "get all users info", notes = "api which shows all users info")
    public String test(){

        List<TestEntity> list = testService.allUsers();
        StringBuffer sb = new StringBuffer();
        TestEntity testEntity = null;
        for(int i = 0; i < list.size(); i++) {
            testEntity = list.get(i);
            sb.append(testEntity.getId() + testEntity.getName() + testEntity.getEmail() + testEntity.getRegDate() + testEntity.getUpdateDate());
        }
        return sb.toString();
    }

    @GetMapping("/user/{email:.+}/name")
    @ApiOperation(value = "get user name by email", notes = "api which shows user name by email address")
    public String userName(@PathVariable("email") String email){

        return testService.findUserNameByEmail(email);
    }

    @DeleteMapping("/user/{email:.+}")
    @ApiOperation(value = "delete user by email", notes = "api which deletes user by email address")
    public void deleteUser(@PathVariable("email") String email){

        testService.deleteUserByEmail(email);
    }

    @PutMapping("/user/{id}/name")
    @ApiOperation(value = "modify user name", notes = "api which modifies user name")
    public void updateUserName(@PathVariable("id") Long id, @RequestBody String newName){

        System.out.println(newName);
        testService.updateUserName(id, newName);
    }
}
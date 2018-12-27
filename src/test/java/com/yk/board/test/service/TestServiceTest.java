package com.yk.board.test.service;

import com.yk.board.test.dto.UserDTO;
import com.yk.board.test.domain.TestEntity;
import com.yk.board.test.repository.TestRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServiceTest {

    @Autowired
    TestService testService;

    @Autowired
    TestRepository testRepository;

    @Test
    public void createUser(){

        // given
        UserDTO userDTO = UserDTO.builder()
                .email("Zzzzz.co.kr@gmail.com")
                .name("YK")
                .build();

        // when
        testService.createUser(userDTO);

        // then
        TestEntity testEntity = testRepository.findByEmail(userDTO.getEmail());
        assertThat(testEntity.getEmail()).isEqualTo(userDTO.getEmail());
        assertThat(testEntity.getName()).isEqualTo(userDTO.getName());
    }

    @Test
    public void deleteUser(){

        // given
        String email = "Zzzzz.co.kr@gmail.com ...18";

        // when
        testService.deleteUserByEmail(email);

        // then
        List<TestEntity> list = testRepository.findAll();
        assertThat(list.size()).isEqualTo(17);
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
        assertThat(testEntity.getName()).isEqualTo(newName);
    }
}

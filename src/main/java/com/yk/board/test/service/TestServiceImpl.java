package com.yk.board.test.service;

import com.yk.board.test.DTO.UserDTO;
import com.yk.board.test.domain.TestEntity;
import com.yk.board.test.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class TestServiceImpl implements TestService{

    TestRepository testRepository;

    @Override
    @Transactional
    public void createUser(UserDTO userDTO){

        testRepository.save(userDTO.toEntity());
    }

    @Override
    @Transactional(readOnly = true)
    // readOnly 속성을 true 함으로써 select 성능을 최적화 시킬 수 있다.
    public List<TestEntity> allUsers() {

        return testRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public String findUserNameByEmail(String email) {

        TestEntity testEntity = testRepository.findByEmail(email);

        return testEntity.getName();
    }

    @Override
    @Transactional
    public void deleteUserByEmail(String email){

        TestEntity testEntity = testRepository.findByEmail(email);
        testRepository.deleteById(testEntity.getId());
    }

    @Override
    @Transactional
    public void updateUserName(Long id, String newName){

        TestEntity testEntity = testRepository.getOne(id);
        testEntity.updateName(newName);
    }
}

package com.yk.board.test.repository;

import com.yk.board.test.domain.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TestRepository extends JpaRepository<TestEntity, Long> {

    public TestEntity findByEmail(String email);
}
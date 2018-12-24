package com.yk.board.test.repository;

import com.yk.board.test.entity.TestEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TestRepository extends CrudRepository<TestEntity, Long> {
}
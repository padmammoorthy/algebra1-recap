package com.algebra1recap.repository;

import com.algebra1recap.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Long> {
    List<TestResult> findByUserIdOrderByCompletedAtDesc(Long userId);
    Optional<TestResult> findTopByUserIdAndTestIdOrderByCompletedAtDesc(Long userId, Long testId);
    List<TestResult> findByUserId(Long userId);
    long countByUserId(Long userId);
}

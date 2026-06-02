package com.algebra1recap.repository;

import com.algebra1recap.model.TestQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, Long> {
    List<TestQuestion> findByTestIdOrderByIdAsc(Long testId);
    Page<TestQuestion> findByTestIdOrderByIdAsc(Long testId, Pageable pageable);
    long countByTestId(Long testId);
}

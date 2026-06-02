package com.algebra1recap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_result")
public class TestResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long testId;
    private Integer score;
    private Integer totalQuestions;
    private LocalDateTime completedAt;
    private Boolean passed;

    public TestResult() {}

    public TestResult(Long userId, Long testId, int score, int totalQuestions, boolean passed) {
        this.userId = userId;
        this.testId = testId;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.passed = passed;
        this.completedAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getTestId() { return testId; }
    public void setTestId(Long testId) { this.testId = testId; }
    public Integer getScore() { return score; }
    public void setScore(Integer score) { this.score = score; }
    public Integer getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(Integer totalQuestions) { this.totalQuestions = totalQuestions; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }
    public Boolean getPassed() { return passed; }
    public void setPassed(Boolean passed) { this.passed = passed; }
    public double getPercentage() {
        if (totalQuestions == null || totalQuestions == 0) return 0;
        return (score * 100.0) / totalQuestions;
    }
}

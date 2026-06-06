package com.algebra1recap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_answer")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long resultId;
    private Long questionId;
    private String userAnswer;

    public UserAnswer() {}

    public UserAnswer(Long resultId, Long questionId, String userAnswer) {
        this.resultId = resultId;
        this.questionId = questionId;
        this.userAnswer = userAnswer;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getResultId() { return resultId; }
    public void setResultId(Long resultId) { this.resultId = resultId; }
    public Long getQuestionId() { return questionId; }
    public void setQuestionId(Long questionId) { this.questionId = questionId; }
    public String getUserAnswer() { return userAnswer; }
    public void setUserAnswer(String userAnswer) { this.userAnswer = userAnswer; }
}

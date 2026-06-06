package com.algebra1recap.model;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String questionText;

    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;

    @Column(length = 1000)
    private String hint;

    @Column(length = 2000)
    private String solutionExplanation;

    private int lessonNumber;
    private String lessonTitle;
    private String topic;
    private String category;

    public Question() {}

    public Question(String questionText, String optionA, String optionB, String optionC, String optionD,
                    String correctAnswer, String hint, int lessonNumber, String lessonTitle, String topic, String category) {
        this.questionText = questionText;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.hint = hint;
        this.lessonNumber = lessonNumber;
        this.lessonTitle = lessonTitle;
        this.topic = topic;
        this.category = category;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public String getOptionA() { return optionA; }
    public void setOptionA(String optionA) { this.optionA = optionA; }
    public String getOptionB() { return optionB; }
    public void setOptionB(String optionB) { this.optionB = optionB; }
    public String getOptionC() { return optionC; }
    public void setOptionC(String optionC) { this.optionC = optionC; }
    public String getOptionD() { return optionD; }
    public void setOptionD(String optionD) { this.optionD = optionD; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    public String getHint() { return hint; }
    public void setHint(String hint) { this.hint = hint; }
    public String getSolutionExplanation() { return solutionExplanation; }
    public void setSolutionExplanation(String solutionExplanation) { this.solutionExplanation = solutionExplanation; }
    public int getLessonNumber() { return lessonNumber; }
    public void setLessonNumber(int lessonNumber) { this.lessonNumber = lessonNumber; }
    public String getLessonTitle() { return lessonTitle; }
    public void setLessonTitle(String lessonTitle) { this.lessonTitle = lessonTitle; }
    public String getTopic() { return topic; }
    public void setTopic(String topic) { this.topic = topic; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPercentage() { return 0; }
}

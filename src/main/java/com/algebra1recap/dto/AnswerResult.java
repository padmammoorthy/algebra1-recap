package com.algebra1recap.dto;

public record AnswerResult(Long questionId, String selectedAnswer, String correctAnswer, boolean correct, String hint, String solutionExplanation) {}

package com.QuizApp.quizservice.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class QuesDTO {
    String categoryName;
    Integer numQuestions;
    String title;
}

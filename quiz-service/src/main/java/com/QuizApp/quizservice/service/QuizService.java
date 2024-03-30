package com.QuizApp.quizservice.service;


import com.QuizApp.quizservice.entity.QuestionWrapper;
import com.QuizApp.quizservice.entity.Quiz;
import com.QuizApp.quizservice.entity.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface QuizService {

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id);

    public ResponseEntity<String> createQuiz(String category, int numQ, String title);

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses);

}

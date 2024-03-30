package com.microservice.questionservice.service;

import com.microservice.questionservice.entity.QuestionWrapper;
import com.microservice.questionservice.entity.Questions;
import com.microservice.questionservice.entity.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface QuesService {
//    public ResponseEntity<List<Questions>> getAllQues();
    public ResponseEntity<List<Questions>> getAllQuestions();
    public ResponseEntity<String> addQuestion(Questions question);
    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category);
//    public ResponseEntity<Questions>  addquestions(Questions ques);
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions);

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds);
    public ResponseEntity<Integer> getScore(List<Response> responses);

}

package com.microservice.questionservice.controller;

import com.microservice.questionservice.entity.QuestionWrapper;
import com.microservice.questionservice.entity.Questions;
import com.microservice.questionservice.entity.Response;
import com.microservice.questionservice.service.QuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin
@RequestMapping("question")
public class Controller
{

    @Autowired
    QuesService questionService;

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Questions>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Questions>> getQuestionsByCategory(@PathVariable String category){
        System.out.println("Here is category");
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody Questions question){
        System.out.println("getting here");
        return  questionService.addQuestion(question);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz
            (@RequestParam String categoryName, @RequestParam Integer numQuestions )
            //question numbers  will comes from quiz service
    {
        return questionService.getQuestionsForQuiz(categoryName, numQuestions);
    }


    //QuestionWrapper do not have ans we dont want ans
    @PostMapping("getQuestions") //to get question based on question Ids
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds){//from quiz service multiple ids
        System.out.println("commes here");
        System.out.println("Received question IDs: " + questionIds);
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("/getScore")
    //it will pass list of responses (id and responseAnser )
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
    {
        return questionService.getScore(responses);
    }

}

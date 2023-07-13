package com.akil.quizapp.controllers;

import com.akil.quizapp.models.Answer;
import com.akil.quizapp.models.QuestionWrapper;
import com.akil.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @GetMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String cat, @RequestParam int noOfQns, @RequestParam String quizTitle){

        return quizService.createQuiz(cat, noOfQns, quizTitle);
    }
    @GetMapping("get/{quizTitle}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable String quizTitle){

        return quizService.getQuiz(quizTitle);
    }
    @PostMapping("submit/{quizTitle}")
    public ResponseEntity<String> submitQuiz(@PathVariable String quizTitle, @RequestBody List<Answer> answers){

        return quizService.submitQuiz(quizTitle, answers);
    }
}

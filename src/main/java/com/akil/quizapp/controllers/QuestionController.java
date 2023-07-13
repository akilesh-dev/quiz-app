package com.akil.quizapp.controllers;

import com.akil.quizapp.models.Question;
import com.akil.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("displayHello")
    @ResponseBody
    public String displayHello(){
        return "Hello";
    }
    @GetMapping(value = "questionList")
    @ResponseBody
    public ResponseEntity<List<Question>> getAllQuestions(){

        return questionService.getAllQuestions();
        //ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS);
    }

    @GetMapping("category/{category}")
    @ResponseBody
    public List<Question> getQuestionsByCategory(@PathVariable String category){
        return questionService.getQuestionsByCategory(category);
    }

    @PutMapping("addQuestion")
    @ResponseBody
    public String addQuestion(@RequestBody Question question){

        return questionService.addQuestion(question);
    }
    @DeleteMapping("deleteQuestion/{id}")
    @ResponseBody
    public String deleteQuestion(@PathVariable int id){
        return questionService.deleteQuestion(id);
    }

    //creating a fallback for all HTTP methods
    @RequestMapping(value = "*",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String fallbackFunction(){
        return "Method failed, fall back";
    }
}

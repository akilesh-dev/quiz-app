package com.akil.quizapp.services;

import com.akil.quizapp.dao.QuestionDao;
import com.akil.quizapp.dao.QuizDao;
import com.akil.quizapp.models.Answer;
import com.akil.quizapp.models.Question;
import com.akil.quizapp.models.QuestionWrapper;
import com.akil.quizapp.models.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> submitQuiz(String quizTitle, List<Answer> answers) {
        Quiz quizList = quizDao.findAllByTitle(quizTitle);
        int score = 0;
        for(Answer a : answers){
            Question currQn = questionDao.findByQuestion(a.getQuestion());
            if(currQn.getAnswer().equals(a.getAnswer())){
                score++;
            }
        }
        return new ResponseEntity<>(MessageFormat.format("Your Score is: {0} out of {1}", score, quizList.getQuestions().size()), HttpStatus.OK);
    }

    public ResponseEntity<String> createQuiz(String cat, int noOfQns, String quizTitle) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizTitle);
        quiz.setQuestions(questionDao.findRandomQuestionsBySubject(noOfQns, cat));
        quizDao.save(quiz);
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(String quizTitle) {

        Quiz quizList = quizDao.findAllByTitle(quizTitle);
        List<QuestionWrapper> questionWrapperList = new ArrayList<>();
        for(Question q : quizList.getQuestions()){
            questionWrapperList.add(new QuestionWrapper(q));
        }

        return new ResponseEntity<>(questionWrapperList, HttpStatus.ACCEPTED);
    }
}

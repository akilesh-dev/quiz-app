package com.akil.quizapp.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Data
public class QuestionWrapper {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sno;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String question;

    public QuestionWrapper(Question q){
        sno = q.getSno();
        optionA = q.getOptionA();
        optionB = q.getOptionB();
        optionC = q.getOptionC();
        optionD = q.getOptionD();
        question = q.getQuestion();
    }
}

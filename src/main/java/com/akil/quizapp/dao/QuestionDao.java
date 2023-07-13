package com.akil.quizapp.dao;

import com.akil.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
    List<Question> findBySubject(String subject);
    @Query(value = "Select * from Questions where subject = :subject order by " +
            "Random() limit :noOfQns", nativeQuery = true)
    List<Question> findRandomQuestionsBySubject(int noOfQns, String subject);
    Question findByQuestion(String question);
}

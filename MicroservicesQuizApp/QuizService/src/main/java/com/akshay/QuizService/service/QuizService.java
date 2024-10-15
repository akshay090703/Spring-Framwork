package com.akshay.QuizService.service;


import com.akshay.QuizService.feign.QuizInterface;
import com.akshay.QuizService.model.QuestionWrapper;
import com.akshay.QuizService.model.Quiz;
import com.akshay.QuizService.model.Response;
import com.akshay.QuizService.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuizInterface quizInterface;

    // RestTemplate -> used for sending http request
    // Service Registry and Server Client -> Eureka by Netflix
    // Feign -> used for directly requesting in the server based on what we want

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepo.save(quiz);

        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Quiz quiz = quizRepo.findById(id).get();

        List<Integer> questionIds = quiz.getQuestions();
        List<QuestionWrapper> questionsForUser = quizInterface.getQuestionsFromId(questionIds).getBody();

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        int right = quizInterface.getScore(responses).getBody();

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}

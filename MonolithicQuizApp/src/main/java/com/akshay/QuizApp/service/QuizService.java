package com.akshay.QuizApp.service;

import com.akshay.QuizApp.model.Question;
import com.akshay.QuizApp.model.QuestionWrapper;
import com.akshay.QuizApp.model.Quiz;
import com.akshay.QuizApp.model.Response;
import com.akshay.QuizApp.repository.QuestionRepo;
import com.akshay.QuizApp.repository.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category, noOfQuestions);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
        Optional<Quiz> quiz = quizRepo.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());

            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(int id, List<Response> responses) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        int right = 0;
        int i = 0;

        for(Response response : responses) {
            if(response.getResponse().equals(questions.get(i).getRightAnswer())) right++;

            i++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}

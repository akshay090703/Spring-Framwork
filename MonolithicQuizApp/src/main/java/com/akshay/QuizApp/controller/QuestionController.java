package com.akshay.QuizApp.controller;

import com.akshay.QuizApp.model.Question;
import com.akshay.QuizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable int id,@RequestBody Question question) {
        Optional<Question> question1 = questionService.getQuestionById(id);

        if(question1.isPresent()) {
            return questionService.addQuestion(question);
        } else {
            return new ResponseEntity<>("Question not present", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("{id}")
    public Optional<Question> getQuestionById(@PathVariable int id) {
        return questionService.getQuestionById(id);
    }

    @DeleteMapping("{id}")
    public String deleteQuestionById(@PathVariable int id) {
        Optional<Question> question = questionService.getQuestionById(id);

        if(question.isPresent()) {
            return questionService.deleteById(id);
        } else {
            return "Question not present";
        }
    }
}

package com.akshay.QuestionService.controller;

import com.akshay.QuestionService.model.Question;
import com.akshay.QuestionService.model.QuestionWrapper;
import com.akshay.QuestionService.model.Response;
import com.akshay.QuestionService.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    @Autowired
    Environment environment;

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

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numOfQuestions) {
        return questionService.getQuestionsForQuiz(categoryName, numOfQuestions);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
        return questionService.getQuestionsFromId(questionIds);
    }

    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
        System.out.println(environment.getProperty("local.server.port"));
        return questionService.getScore(responses);
    }
}

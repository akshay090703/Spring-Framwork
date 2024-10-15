package com.akshay.QuizService.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class QuizDTO {
    String categoryName;
    Integer numOfQuestions;
    String title;
}

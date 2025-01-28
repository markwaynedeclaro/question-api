package com.miguel.questionapi.model;

import lombok.Data;

@Data
public class Question {
    private String type;
    private String difficulty;
    private String category;
    private String question;
    private String correct_answer;
    private String[] incorrect_answers;
}

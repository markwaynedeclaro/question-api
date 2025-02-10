package com.miguel.questionapi.model;

import lombok.Data;

@Data
public class TriviaApiResponse {
    private String response_code;
    private Question[] results;
}

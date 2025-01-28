package com.miguel.questionapi.configuration;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AppConfig {

    @Value("${api.version}")
    private String apiVersion;

    @Value(("${trivia.api.url}"))
    private String triviaApiBaseUrl;

    @Value("${trivia.api.connectTimeout}")
    private int connectTimeout;

    @Value("${trivia.api.readTimeout}")
    private int readTimeout;

    @Value("${trivia.api.writeTimeout}")
    private int writeTimeout;

    @Value("${parameter.default.amount}")
    private String defaultAmount;
}

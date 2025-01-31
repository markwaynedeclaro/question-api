package com.miguel.questionapi.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.miguel.questionapi.configuration.AppConfig;
import com.miguel.questionapi.enums.Category;

import com.miguel.questionapi.exception.ApiNewCallException;
import com.miguel.questionapi.model.Question;
import com.miguel.questionapi.model.TriviaApiResponse;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

import static com.miguel.questionapi.utility.Constants.MULTIPLE;

@Service
public class QuestionService {

    private final AppConfig appConfig;
    private final OkHttpClient client;

    public QuestionService(OkHttpClient client, AppConfig appConfig) {
        this.appConfig = appConfig;
        this.client = client;
    }

    public List<Question> getQuestions(String amount, String category, String difficulty, String type) throws ApiNewCallException {
        Map<String, String> parameters = new HashMap<>();

        parameters.put("amount", StringUtils.isNotEmpty(amount) && Integer.parseInt(amount) > 0 ? amount : appConfig.getDefaultAmount());
        parameters.put("type", StringUtils.isNotEmpty(type) ? type : MULTIPLE);
        parameters.put("category", StringUtils.isNotEmpty(category) ? Integer.toString(Category.getCategoryNumberByName(category)) : Integer.toString(Category.GENERAL_KNOWLEDGE.getCategoryNumber()));

        if (StringUtils.isNotEmpty(difficulty)) {
            parameters.put("difficulty", difficulty);
        }

        TriviaApiResponse triviaApiResponse =  executeRequest(this.getRequest(parameters), new TypeReference<TriviaApiResponse>() {});
        return Arrays.asList(triviaApiResponse.getResults());
    }


    @Async
    private <T> T executeRequest(Request request, TypeReference<T> typeReference) throws ApiNewCallException {
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();
                return new ObjectMapper().readValue(responseBody, typeReference);
            } else {
                throw new ApiNewCallException("Unexpected code " + response.code());
            }
        } catch (IOException e) {
            throw new ApiNewCallException("Client execution error encountered: " + e.getMessage());
        }
    }


    private Request getRequest(Map<String, String> parameterMap) {
        Builder builder = Objects.requireNonNull(HttpUrl.parse(appConfig.getTriviaApiBaseUrl())).newBuilder();
        if (!parameterMap.isEmpty()) {
            for (Map.Entry<String, String> entry : parameterMap.entrySet()) {
                builder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        HttpUrl url = builder.build();

        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }
}

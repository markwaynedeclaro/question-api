package com.miguel.questionapi.controller;

import com.miguel.questionapi.exception.ApiNewCallException;
import com.miguel.questionapi.model.Question;
import com.miguel.questionapi.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import static com.miguel.questionapi.utility.Constants.MULTIPLE;

@RestController
@Tag(name = "03 - Questions", description = "Trivia Question Endpoints")
@RequestMapping("/${api.version}/questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Operation(
            summary = "Fetch all Trivia Questions",
            description = "fetches all trivia question api entities from https://opentdb.com/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Question>> getQuestions(
            @RequestParam(required = false) String amount,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String difficulty)
            throws ApiNewCallException {

        List<Question> questions = questionService.getQuestions(amount, category, difficulty, MULTIPLE);
        if (questions == null || questions.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(questions);
    }

}

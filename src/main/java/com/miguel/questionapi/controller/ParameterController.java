package com.miguel.questionapi.controller;

import com.miguel.questionapi.service.ParameterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/${api.version}/parameters")
public class ParameterController {

    private final ParameterService parameterService;

    public ParameterController(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @Operation(
            tags = "02 - Parameters",
            summary = "Fetch all Trivia Categories",
            description = "fetches all trivia question api categories from https://opentdb.com/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping(value="/categories", produces = "application/json")
    public ResponseEntity<List<String>> getAllCategories() {
        List<String> categoryList = parameterService.getAllCategories();
        if (Objects.isNull(categoryList) || categoryList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoryList);
    }

    @Operation(
            tags = "02 - Parameters",
            summary = "Fetch all Trivia Difficulty levels",
            description = "fetches all trivia question api difficulty levels from https://opentdb.com/")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation")
    })
    @GetMapping(value = "/difficulty-levels", produces = "application/json")
    public ResponseEntity<List<String>> getAllDifficultyLevels() {
        List<String> dificultyLevelList = parameterService.getAllDifficultyLevels();
        if (Objects.isNull(dificultyLevelList) || dificultyLevelList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dificultyLevelList);
    }
}

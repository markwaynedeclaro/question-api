package com.miguel.questionapi.service;

import com.miguel.questionapi.enums.Category;
import com.miguel.questionapi.enums.Difficulty;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ParameterService {

    public List<String> getAllCategories() {
        return Arrays.stream(Category.values()).map(Category::getCategoryName).toList();
    }

    public List<String> getAllDifficultyLevels() {
        return Arrays.stream(Difficulty.values()).map(Difficulty::getDifficultyLevel).toList();
    }

}

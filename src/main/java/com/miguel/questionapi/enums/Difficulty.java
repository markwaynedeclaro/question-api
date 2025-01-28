package com.miguel.questionapi.enums;

import lombok.Getter;

@Getter
public enum Difficulty {
    ANY("any"),
    EASY("easy"),
    MEDIUM("medium"),
    HARD("hard");

    private final String difficultyLevel;

    Difficulty(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

}

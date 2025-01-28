package com.miguel.questionapi.enums;

import lombok.Getter;
import com.miguel.questionapi.exception.IllegalArgumentException;

@Getter
public enum Category {
    GENERAL_KNOWLEDGE(9, "General Knowledge"),
    ANIMALS(27, "Animals"),
    ENTERTAINMENT_FILM(11, "Entertainment: Film"),
    ENTERTAINMENT_MUSIC(12, "Entertainment: Music");

    private final int categoryNumber;
    private final String categoryName;

    Category(int categoryNumber, String categoryName) {
        this.categoryNumber = categoryNumber;
        this.categoryName = categoryName;
    }

    public static int getCategoryNumberByName(String categoryName) {
        for (Category category : Category.values()) {
            if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
                return category.getCategoryNumber();
            }
        }
        throw new IllegalArgumentException("Category name not found: " + categoryName);
    }
}

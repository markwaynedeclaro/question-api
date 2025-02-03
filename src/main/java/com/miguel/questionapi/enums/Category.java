package com.miguel.questionapi.enums;

import lombok.Getter;
import com.miguel.questionapi.exception.IllegalArgumentException;

@Getter
public enum Category {
    GENERAL_KNOWLEDGE(9, "General Knowledge"),
    ENTERTAINMENT_BOOKS(10, "Entertainment: Books"),
    ENTERTAINMENT_FILM(11, "Entertainment: Film"),
    ENTERTAINMENT_MUSIC(12, "Entertainment: Music"),
    ENTERTAINMENT_MUSICAL_AND_THEATRES(13, "Entertainment: Musicals & Theatres"),
    ENTERTAINMENT_TELEVISIONS(14, "Entertainment: Television"),
    ENTERTAINMENT_VIDEO_GAMES(15, "Entertainment: Video Games"),
    ENTERTAINMENT_BOARD_GAMES(16, "Entertainment: Board Games"),
    SCIENCE_AND_NATURE(17, "Science & Nature"),
    SCIENCE_COMPUTERS(18, "Science: Computers"),
    SCIENCE_MATHEMATICS(19, "Science: Mathematics"),
    MYTHOLOGY(20, "Mythology"),
    SPORTS(21, "Sports "),
    GEOGRAPHY(22, "Geography"),
    HISTORY(23, "History"),
    POLITICS(24, "Politics"),
    ART(25, "Art"),
    CELEBRITIES(26, "Celebrities"),
    ANIMALS(27, "Animals"),
    VEHICLES(28, "Vehicles"),
    ENTERTAINMENT_COMICS(29, "Entertainment: Comics"),
    SCIENCE_GADGETS(30, "Science: Gadgets"),
    ENTERTAINMENT_JAPANESE_ANIME_AND_MANGA(31, "Entertainment: Japanese Anime & Manga"),
    ENTERTAINMENT_CARTOON_AND_ANIMATIONS(31, "Entertainment: Cartoon & Animations");

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

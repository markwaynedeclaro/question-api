package com.miguel.questionapi.enums;

import org.junit.jupiter.api.Test;
import com.miguel.questionapi.exception.IllegalArgumentException;

import static org.junit.jupiter.api.Assertions.*;

public class CategoryTest {

    @Test
    public void testGetCategoryNumberByName_ValidCategory() {
        int categoryNumber = Category.getCategoryNumberByName("General Knowledge");
        assertEquals(9, categoryNumber);

        categoryNumber = Category.getCategoryNumberByName("Entertainment: Music");
        assertEquals(12, categoryNumber);
    }

    @Test
    public void testGetCategoryNumberByName_IgnoreCase() {
        int categoryNumber = Category.getCategoryNumberByName("general knowledge");
        assertEquals(9, categoryNumber);

        categoryNumber = Category.getCategoryNumberByName("ENTERTAINMENT: MUSIC");
        assertEquals(12, categoryNumber);
    }

    @Test
    public void testGetCategoryNumberByName_InvalidCategory() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Category.getCategoryNumberByName("Invalid Category");
        });
        assertEquals("Category name not found: Invalid Category", exception.getMessage());
    }
}
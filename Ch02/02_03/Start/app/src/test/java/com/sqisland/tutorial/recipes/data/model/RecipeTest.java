package com.sqisland.tutorial.recipes.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

// Create Test class
public class RecipeTest {

    // This is a test method that will
    // parse the water.txt file
    @Test
    public void water() {

        // Get the txt file as an InputStream
        InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");

        // Get a Recipe object from the stream
        Recipe recipe = Recipe.readFromStream(stream);

        // Assert that the Recipe is not null
        assertNotNull(recipe);
    }

}
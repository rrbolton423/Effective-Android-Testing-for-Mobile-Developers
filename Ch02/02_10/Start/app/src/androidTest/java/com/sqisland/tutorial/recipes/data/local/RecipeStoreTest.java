package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.sqisland.tutorial.recipes.data.model.Recipe;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RecipeStoreTest {
    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());
    }

    @Test
    public void count() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(4, store.recipes.size());
    }

    // This test method verifies that we can retrieve a recipe
    // by its ID
    @Test
    public void getChocolatePudding() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, "recipes");

        // Get the chocolate pudding Recipe from the RecipeStore
        Recipe recipe = store.getRecipe("chocolate_pudding");

        // Verify that the Recipe is not null
        assertNotNull(recipe);

        // Assert that the id of the Recipe object is "chocolate_pudding"
        assertEquals("chocolate_pudding", recipe.id);

        // Assert that the title of the Recipe object is "Chocolate Pudding"
        assertEquals("Chocolate Pudding", recipe.title);
    }
}
package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeStoreTest {
    @Test
    public void nullDirectory() {
        Context context = InstrumentationRegistry.getTargetContext();
        RecipeStore store = new RecipeStore(context, null);
        assertNotNull(store);
        assertNotNull(store.recipes);
        assertEquals(0, store.recipes.size());
    }

    // This test method verifies the count of the number of
    // recipes in the assets folder
    @Test
    public void count() {
        Context context = InstrumentationRegistry.getTargetContext();

        // Pass the directory name into the RecipeStore constructor
        RecipeStore store = new RecipeStore(context, "recipes");

        assertNotNull(store);
        assertNotNull(store.recipes);

        // Assert that we are expecting 4 recipes
        assertEquals(4, store.recipes.size());
    }
}
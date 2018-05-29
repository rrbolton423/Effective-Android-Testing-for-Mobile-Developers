package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

// Create a Test class for the RecipeStore
public class RecipeStoreTest {

    // Test checks for a null directory
    @Test
    public void nullDirectory() {

        // Get the context for the app
        Context context = InstrumentationRegistry.getTargetContext();

        // Create a RecipeStore
        RecipeStore store = new RecipeStore(context, null);

        // Assert the RecipeStore being not null
        assertNotNull(store);

        // Assert the Recipe List being not null
        assertNotNull(store.recipes);

        // Assert the size of the Recipe List being 0
        assertEquals(0, store.recipes.size());

    }
}
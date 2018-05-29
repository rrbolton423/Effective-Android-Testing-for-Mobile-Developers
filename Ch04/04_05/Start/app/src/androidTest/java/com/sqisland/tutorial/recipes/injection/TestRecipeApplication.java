package com.sqisland.tutorial.recipes.injection;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;

// Have TestRecipeApplication extend "RecipeApplication". This
// way, it can be used in place of "RecipeApplication"
// during testing.
public class TestRecipeApplication extends RecipeApplication {

    // Make a final field called Favorites,
    // which is an in-memory Favorites
    private final Favorites favorites = new InMemoryFavorites();

    // Override the getFavorites() function so that it returns
    // SharedPreferencesFavorites instead of in-memory favorites
    @Override
    public Favorites getFavorites() {

        // Return the favorites object
        return favorites;
    }
}

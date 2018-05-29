package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipePresenter {

    // Add RecipeStore field
    private final RecipeStore store;

    // Add Recipe field
    private Recipe recipe;

    // Add constructor
    public RecipePresenter(RecipeStore store) {
        this.store = store;
    }

    // Load the Recipe using the Store when given an ID
    public void loadRecipe(String id) {

        // Store it as a field in the presenter
        recipe = store.getRecipe(id);
    }
}

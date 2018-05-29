package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipePresenter {
    private final RecipeStore store;

    // Declare a RecipeContract View object
    RecipeContract.View view;

    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view) {
        this.store = store;

        // Save the view
        this.view = view;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);

        // If the recipe is null...
        if (recipe == null) {

            // Show error
            view.showRecipeNotFoundError();
        }
    }
}

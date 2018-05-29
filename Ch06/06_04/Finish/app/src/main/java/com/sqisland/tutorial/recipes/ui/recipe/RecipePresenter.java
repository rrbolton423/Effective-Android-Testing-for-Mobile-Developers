package com.sqisland.tutorial.recipes.ui.recipe;

import android.view.View;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipePresenter {
    private final RecipeStore store;
    private final RecipeContract.View view;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store, RecipeContract.View view) {
        this.store = store;
        this.view = view;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
        if (recipe == null) {
            view.showRecipeNotFoundError();
        }
    }
}

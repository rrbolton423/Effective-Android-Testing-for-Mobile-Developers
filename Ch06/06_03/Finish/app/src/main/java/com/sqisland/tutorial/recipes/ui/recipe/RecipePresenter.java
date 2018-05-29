package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipePresenter {
    private final RecipeStore store;
    private Recipe recipe;

    public RecipePresenter(RecipeStore store) {
        this.store = store;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
    }
}

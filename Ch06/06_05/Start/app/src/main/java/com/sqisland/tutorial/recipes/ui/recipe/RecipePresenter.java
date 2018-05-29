package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

// Keep the Presenter pure Java, having zero Android functionality
public class RecipePresenter {
    private final RecipeStore store;
    private final RecipeContract.View view;

    // Create a Favorites field
    private final Favorites favorites;

    private Recipe recipe;

    // Add favorites as a parameter in the RecipePresenter
    public RecipePresenter(RecipeStore store, RecipeContract.View view, Favorites favorites) {
        this.store = store;
        this.view = view;
        this.favorites = favorites;
    }

    public void loadRecipe(String id) {
        recipe = store.getRecipe(id);
        if (recipe == null) {
            view.showRecipeNotFoundError();
        } else {

            // Update the title and description view via the View
            // interface. Not directly in the Presenter
            view.setTitle(recipe.title);
            view.setDescription(recipe.description);

            // Set the Favorite via the View, not directly in the Presenter
            view.setFavorite(favorites.get(recipe.id));
        }
    }
}

package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class RecipePresenterTest {
    private RecipeStore store;
    private Favorites favorites;
    private RecipeContract.View view;
    private RecipePresenter presenter;

    @Before
    public void setup() {
        store = Mockito.mock(RecipeStore.class);
        favorites = Mockito.mock(Favorites.class);
        view = Mockito.mock(RecipeContract.View.class);
        presenter = new RecipePresenter(store, view, favorites);
    }

    // This method tests if a Recipe is not found
    @Test
    public void recipeNotFound() {

        // When the getRecipe() function is called on the Recipe store,
        // whatever the parameter is (any String), return null.
        Mockito.when(store.getRecipe(Mockito.anyString())).thenReturn(null);

        // Load a Recipe
        presenter.loadRecipe("no_such_recipe");

        // Verify that the showRecipeNotFound() is called
        // This says that a function on the object view has been called once,
        // in this case "showRecipeNotFoundError()" has been called once
        Mockito.verify(view, Mockito.times(1)).showRecipeNotFoundError();
    }
}
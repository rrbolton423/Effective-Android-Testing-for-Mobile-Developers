package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

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

    @Test
    public void recipeNotFound() {
        Mockito.when(store.getRecipe(Mockito.anyString())).thenReturn(null);
        presenter.loadRecipe("no_such_recipe");
        Mockito.verify(view, Mockito.times(1)).showRecipeNotFoundError();
    }

    @Test(expected = IllegalStateException.class)
    public void toggleWithoutLoad() {
        presenter.toggleFavorite();
    }
}
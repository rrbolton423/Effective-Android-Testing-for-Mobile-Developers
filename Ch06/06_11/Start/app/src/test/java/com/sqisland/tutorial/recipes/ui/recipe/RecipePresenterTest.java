package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.InputStream;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

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

    // This method will test loading a actual Recipe
    @Test
    public void loadWaterAndFavorite() {

        // Get a Recipe from the assets folder
        InputStream stream = RecipePresenterTest.class.getResourceAsStream("/recipes/water.txt");
        Recipe recipe = Recipe.readFromStream(stream);

        // Return the Recipe when the store's getRecipe() method is called
        Mockito.when(store.getRecipe(Mockito.anyString())).thenReturn(recipe);

        // Return "TRUE" when the favorite's toggle() method is called
        Mockito.when(favorites.toggle(Mockito.anyString())).thenReturn(true);

        // Load the "water" Recipe
        presenter.loadRecipe("water");

        /*
        Verify the behavior when we try to favorite this Recipe
         */

        // Make the Recipe a favorite. The initial state is false,
        // so when toggled here, it will become true.
        presenter.toggleFavorite();

        // Create an ArgumentCaptor object of type "Boolean"
        ArgumentCaptor<Boolean> captor = ArgumentCaptor.forClass(Boolean.class);

        // We want to verify that the setFavorite() function is called
        // twice. setFavorites() is called once when we load the recipe,
        // and twice when we toggle the favorite in this Test method,
        // to update the UI.
        Mockito.verify(view, Mockito.times(2))
                .setFavorite(captor.capture()); // Pass the ArgumentCaptor to capture the value
        // that is passed to the setFavorite() function.

        // Ask the captor to give us the first value it has captured, and verify
        // that the first entry is false
        assertFalse(captor.getAllValues().get(0));

        // Ask the captor to give us the second value it has captured, and verify
        // that the second entry is true
        assertTrue(captor.getAllValues().get(1));
    }
}

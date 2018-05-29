package com.sqisland.tutorial.recipes.ui.recipe;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;

import org.junit.Before;
import org.mockito.Mockito;

public class RecipePresenterTest {

    // Add needed fields
    private RecipeStore store;
    private Favorites favorites;
    private RecipeContract.View view;
    private RecipePresenter presenter;

    // Add set-up method to instantiate fields with @Before annotation
    @Before
    public void setup() {

        /*
        Create a store, favorite, view, and presenter
         */

        // This tells Mockito to create an object with the same
        // function signatures as RecipeStore, plus, hooks to
        // specify its behavior when the functions are called.
        store = Mockito.mock(RecipeStore.class);
        favorites = Mockito.mock(Favorites.class);
        view = Mockito.mock(RecipeContract.View.class);

        // Instantiate the REAL Presenter, passing in a STUB
        // store, view, and favorite so that we can test the
        // behavior of the Presenter without depending on the fact
        // store, favorite or view are doing the right thing.
        // If they're all real objects, when we find a bug, we don't
        // know whether it's from the presenter, or from all these
        // other dependencies. If we have a bug, we will know that it
        // is the presenter.
        presenter = new RecipePresenter(store, view, favorites);
    }

}
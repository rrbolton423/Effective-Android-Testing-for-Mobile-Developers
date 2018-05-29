package com.sqisland.tutorial.recipes.injection;

import android.app.Application;

import com.sqisland.tutorial.recipes.data.local.Favorites;
import com.sqisland.tutorial.recipes.data.local.SharedPreferencesFavorites;

// Have the RecipeApplication class extend "Application"
public class RecipeApplication extends Application {

    // Declare a Favorites object
    private Favorites favorites = null;

    // This method returns the SharedPreferencesFavorites object
    public Favorites getFavorites() {

        // If favorites is null...
        if (favorites == null) {

            // Create a new instance of SharedPreferencesFavorites
            favorites = new SharedPreferencesFavorites(this);
        }

        // Return the SharedPreferencesFavorites object
        return favorites;
    }
}

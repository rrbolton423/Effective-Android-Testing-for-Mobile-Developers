package com.sqisland.tutorial.recipes.test;

import android.content.Intent;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;
import com.sqisland.tutorial.recipes.injection.TestRecipeApplication;
import com.sqisland.tutorial.recipes.ui.recipe.RecipeActivity;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    private final InMemoryFavorites favorites;

    public RecipeRobot() {
        TestRecipeApplication app = (TestRecipeApplication)
                InstrumentationRegistry.getTargetContext().getApplicationContext();
        favorites = (InMemoryFavorites) app.getFavorites();
        favorites.clear();
    }

    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot launch(ActivityTestRule rule, String id) {

        // Create an Intent
        Intent intent = new Intent();

        // Put a Recipe ID as an extra in the Intent
        intent.putExtra(RecipeActivity.KEY_ID, id);

        // Launch the Activity with this intent so we can
        // pass in the Recipe id
        rule.launchActivity(intent);

        // Return the Robot
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }

    // This method sets the favorite of a Recipe
    public RecipeRobot setFavorite(String id) {

        // Save the Recipe as a favorite
        favorites.put(id, true);

        // Return the Robot
        return this;
    }

    // This method checks if a Recipe is a favorite
    public RecipeRobot isFavorite() {

        // Check if the title field is selected
        return checkIsSelected(R.id.title);
    }

    // This method checks if a Recipe is a favorite
    public RecipeRobot clickToFavorite() {

        // Check if the title field is a favorite once clicked
        return checkClickToFavorite(R.id.title);
    }
}

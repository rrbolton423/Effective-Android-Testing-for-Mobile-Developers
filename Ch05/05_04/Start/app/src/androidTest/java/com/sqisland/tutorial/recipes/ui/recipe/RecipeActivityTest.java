package com.sqisland.tutorial.recipes.ui.recipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;
import com.sqisland.tutorial.recipes.injection.TestRecipeApplication;
import com.sqisland.tutorial.recipes.test.RecipeRobot;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

public class RecipeActivityTest {
    private static final String CARROTS_ID = "creamed_carrots";
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule
            = new ActivityTestRule<>(
                    RecipeActivity.class, true, false);

    @Test
    public void recipeNotFound() {
        new RecipeRobot()
                .launch(activityRule)
                .noTitle()
                .description(R.string.recipe_not_found);
    }

    @Test
    public void clickToFavorite() {

        // Create a new RecipeRobot instance and
        // check if a view is a favorite when clicked
        new RecipeRobot()
                .launch(activityRule, CARROTS_ID) // Launch the Recipe
                .checkClickToFavorite(); // Verify that the title is a favorite when clicked
    }

    @Test
    public void alreadyFavorite() {

        // Create a new RecipeRobot instance and
        // set the favorite
        new RecipeRobot()
                .setFavorite(CARROTS_ID) // Set the Recipe as a favorite
                .launch(activityRule, CARROTS_ID) // Launch the Recipe
                .isFavorite(); // Verify that the title is selected
    }

    private void launchRecipe(String id) {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, id);
        activityRule.launchActivity(intent);
    }
}
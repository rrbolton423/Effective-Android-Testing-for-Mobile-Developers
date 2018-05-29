package com.sqisland.tutorial.recipes.ui.recipe;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

public class RecipeActivityTest {

    // Create a ActivityTestRule to Test the RecipeActivity
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule
            = new ActivityTestRule<> (
                    RecipeActivity.class, true, false);

    // Verify that the TextView displays the text RecipeNotFound
    @Test
    public void recipeNotFound() {

        // Launch the RecipeActivity, not loading a valid
        // recipe by passing in null
        activityRule.launchActivity(null);

        // Assert that Description TextView shows RecipeNotFound
        onView(withId(R.id.description))
                .check(matches(withText(R.string.recipe_not_found)));

        // Assert that Title TextView's text is not displayed
        onView(withId(R.id.title))
                .check(matches(not(isDisplayed())));
    }

    @Test
    public void clickToFavorite() {

        // Create an Intent object
        Intent intent = new Intent();

        // Pass the Recipe ID to the IntentExtra
        intent.putExtra(RecipeActivity.KEY_ID, "creamed_carrots");

        // Launch the Activity with the Intent
        activityRule.launchActivity(intent);

        // Verify that the TitleView starts off with NOT SELECTED
        // then...
        // verify that when you click on it, it changes to SELECTED
        onView(withId(R.id.title))
                .check(matches(withText("Creamed Carrots")))
                .check(matches(not(isSelected())))
                .perform(click())
                .check(matches(isSelected()));
    }
}
package com.sqisland.tutorial.recipes.ui.recipe;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.InMemoryFavorites;
import com.sqisland.tutorial.recipes.injection.TestRecipeApplication;

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

public class RecipeActivityTest {
    @Rule
    public ActivityTestRule<RecipeActivity> activityRule
            = new ActivityTestRule<>(
                    RecipeActivity.class, true, false);

    // Create an instance of InMemoryFavorites
    private InMemoryFavorites favorites;

    // Put @Before annotation to do setup of the
    // InMemoryFavorites, and initialization before each
    // test method. We do this so that we can have a clean
    // InMemoryFavorites
    @Before
    public void clearFavorites() {

        // Get the TestRecipeApplication
        TestRecipeApplication app =
                (TestRecipeApplication) InstrumentationRegistry.getTargetContext()
                .getApplicationContext();

        // Initialize the InMemoryFavorites from the application
        favorites = (InMemoryFavorites) app.getFavorites();

        // Clear the InMemoryFavorites before launching the Activity
        favorites.clear();
    }

    @Test
    public void recipeNotFound() {
        activityRule.launchActivity(null);

        onView(withId(R.id.description))
                .check(matches(withText(R.string.recipe_not_found)));
        onView(withId(R.id.title))
                .check(matches(not(isDisplayed())));
    }

    @Test
    public void clickToFavorite() {
        Intent intent = new Intent();
        intent.putExtra(RecipeActivity.KEY_ID, "creamed_carrots");
        activityRule.launchActivity(intent);

        onView(withId(R.id.title))
                .check(matches(withText("Creamed Carrots")))
                .check(matches(not(isSelected())))
                .perform(click())
                .check(matches(isSelected()));
    }
}
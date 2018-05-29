package com.sqisland.tutorial.recipes.test;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;

// This class extends ScreenRobot of type RecipeRobot
public class RecipeRobot extends ScreenRobot<RecipeRobot> {

    /*
    All of these methods return RecipeRobot because we want
    to chain them together
     */

    // Add the launch function
    public RecipeRobot launch(ActivityTestRule rule) {

        // Launch the Activity
        rule.launchActivity(null);

        // Return
        return this;
    }

    // We are going to use the function checkIsHidden()
    // to verify that the title view is hidden.
    public RecipeRobot notTitle() {

        // Check is the view is hidden
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {

        // Check if the description has specific text
        return checkViewHasText(R.id.description, stringId);
    }
}

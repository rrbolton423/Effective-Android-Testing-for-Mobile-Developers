package com.sqisland.tutorial.recipes.test;

import android.support.annotation.StringRes;
import android.support.test.rule.ActivityTestRule;

import com.sqisland.tutorial.recipes.R;

public class RecipeRobot extends ScreenRobot<RecipeRobot> {
    public RecipeRobot launch(ActivityTestRule rule) {
        rule.launchActivity(null);
        return this;
    }

    public RecipeRobot noTitle() {
        return checkIsHidden(R.id.title);
    }

    public RecipeRobot description(@StringRes int stringId) {
        return checkViewHasText(R.id.description, stringId);
    }
}

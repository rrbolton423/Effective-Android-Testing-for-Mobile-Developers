package com.sqisland.tutorial.recipes.test;

import android.support.annotation.IdRes;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.not;

// This is an abstract class that contains View related methods
public abstract class ScreenRobot <T extends ScreenRobot> {

    // Method receives multiple viewIds,
    // checks if the views are hidden,
    // and returns the ScreenRobot
    public T checkIsHidden(@IdRes int... viewIds) {

        // Loop through the View Ids passed into the method
        for (int viewId : viewIds) {

            // Check that each of them are not displayed
            onView(withId(viewId))
                    .check(matches(not(isDisplayed())));
        }

        // Return this, the Robot itself
        return (T) this;
    }
}

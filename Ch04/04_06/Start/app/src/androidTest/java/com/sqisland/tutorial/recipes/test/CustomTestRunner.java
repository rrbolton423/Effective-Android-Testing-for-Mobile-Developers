package com.sqisland.tutorial.recipes.test;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.sqisland.tutorial.recipes.injection.TestRecipeApplication;

// Have the CustomTestRunner extends "AndroidJUnitRunner"
// in order to use TestRecipeApplication during testing
public class CustomTestRunner extends AndroidJUnitRunner {

    // To have the TestRunner execute "TestRecipeApplication" instead
    // of the normal "RecipeApplication", we need to override the
    // "newApplication()" function
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {

        // In the call to super(), pass "TestRecipeApplication.class.getName()"
        // as the second parameter
        return super.newApplication(cl, TestRecipeApplication.class.getName(), context);
    }
}

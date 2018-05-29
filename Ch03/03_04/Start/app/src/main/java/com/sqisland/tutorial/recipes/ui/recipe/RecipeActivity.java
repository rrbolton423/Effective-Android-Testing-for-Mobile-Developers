package com.sqisland.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.sqisland.tutorial.recipes.R;

// Have Activity extend "AppCompatActivity"
public class RecipeActivity extends AppCompatActivity {

    // Define constant key for Recipe id's
    public static final String KEY_ID = "id";

    // Override onCreate() function
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout file of the Activity
        setContentView(R.layout.activity_recipe);


    }
}

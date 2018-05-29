package com.sqisland.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipeActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        // Get a reference to the Title TextView in the layout
        TextView titleView = (TextView) findViewById(R.id.title);

        // Get a reference to the Description TextView in the layout
        TextView descriptionView = (TextView) findViewById(R.id.description);

        // Get a reference to the RecipeStore
        RecipeStore store = new RecipeStore(this,"recipes");

        // Get the id of the Recipe that was clicked from the Intent
        String id = getIntent().getStringExtra(KEY_ID);

        // Retrieve the Recipe from the RecipeStore via it's id
        Recipe recipe = store.getRecipe(id);

        // If the recipe is null...
        if (recipe == null) {

            // Hide the titleView
            titleView.setVisibility(View.GONE);

            // Change the description view to say "recipe not found"
            descriptionView.setText(R.string.recipe_not_found);

            // Return from the method if there was no valid Recipe
            return;
        }

        // Display the title of the Recipe object
        titleView.setText(recipe.title);

        // Display the description of the Recipe object
        descriptionView.setText(recipe.description);
    }
}

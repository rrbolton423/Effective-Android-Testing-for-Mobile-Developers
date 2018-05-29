package com.sqisland.tutorial.recipes.ui.recipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.local.SharedPreferencesFavorites;
import com.sqisland.tutorial.recipes.data.model.Recipe;

public class RecipeActivity extends AppCompatActivity {
    public static final String KEY_ID = "id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        final TextView titleView = (TextView) findViewById(R.id.title);
        TextView descriptionView = (TextView) findViewById(R.id.description);

        RecipeStore store = new RecipeStore(this, "recipes");
        String id = getIntent().getStringExtra(KEY_ID);
        final Recipe recipe = store.getRecipe(id);

        if (recipe == null) {
            titleView.setVisibility(View.GONE);
            descriptionView.setText(R.string.recipe_not_found);
            return;
        }

        // Create a SharedPreferencesFavorites object
        final SharedPreferencesFavorites favorites = new
                SharedPreferencesFavorites(this);

        // Get the favorite value of the previously stored Recipe,
        // the value "false" is returned for the first time
        final boolean favorite = favorites.get(recipe.id);

        // Update the UI
        titleView.setSelected(favorite);

        // Set a click listener on the TextView
        titleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Toggle the the favorite value of th Recipe
                boolean result = favorites.toggle(recipe.id);

                // Update the UI
                titleView.setSelected(result);
            }
        });

        titleView.setText(recipe.title);
        descriptionView.setText(recipe.description);
    }
}
package com.sqisland.tutorial.recipes.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;

// Create RecyclerViewAdapter class
public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

    // Declare a RecipeStore object
    private final RecipeStore store;

    // Create RecipeStore constructor
    public RecipeAdapter(RecipeStore store) {

        // Save the store object to a field of the class
        this.store = store;
    }

    // Inflate a View for each of the items in the
    // RecyclerView
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate the TextView
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);

        // Pass the View to the ViewHolder class
        return new RecipeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {

        // Retrieve the current Recipe from the position in the list
        final Recipe recipe = store.recipes.get(position);

        // Bind / Populate the ViewHolder with the data from the Recipe
        holder.textView.setText(recipe.title);
    }

    @Override
    public int getItemCount() {

        // Return the size of the list
        return store.recipes.size();
    }
}

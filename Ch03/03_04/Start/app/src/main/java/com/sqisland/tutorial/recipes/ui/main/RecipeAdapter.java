package com.sqisland.tutorial.recipes.ui.main;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;
import com.sqisland.tutorial.recipes.data.model.Recipe;
import com.sqisland.tutorial.recipes.ui.recipe.RecipeActivity;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    private final RecipeStore store;

    public RecipeAdapter(RecipeStore store) {
        this.store = store;
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item, parent, false);
        return new RecipeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RecipeViewHolder holder, int position) {
        final Recipe recipe = store.recipes.get(position);
        holder.textView.setText(recipe.title);

        // Set a click listener on current the TextView in the ViewHolder
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Get the Context
                Context context = holder.textView.getContext();

                // Create an Intent to the RecipeActivity
                Intent intent = new Intent(context, RecipeActivity.class);

                // Pass the id of the current Recipe into the Intent,
                // under the key "RecipeActivity.KEY_ID"
                intent.putExtra(RecipeActivity.KEY_ID, recipe.id);

                // Launch the Activity
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return store.recipes.size();
    }
}

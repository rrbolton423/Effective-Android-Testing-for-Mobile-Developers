package com.sqisland.tutorial.recipes.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

// Create ViewHolder class
public class RecipeViewHolder extends RecyclerView.ViewHolder {

    // Create TextView
    public final TextView textView;

    // Create ViewHolder Constructor
    public RecipeViewHolder(View itemView) {
        super(itemView);

        // Instantiate the TextView
        textView = (TextView) itemView;
    }
}

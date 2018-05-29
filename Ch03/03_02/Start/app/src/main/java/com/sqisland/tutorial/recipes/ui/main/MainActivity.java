package com.sqisland.tutorial.recipes.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sqisland.tutorial.recipes.R;
import com.sqisland.tutorial.recipes.data.local.RecipeStore;

public class MainActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Get a reference to the RecyclerView
    RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recipes);

    // Get a reference to the RecipeStore
    RecipeStore store = new RecipeStore(this,"recipes");

    // Get a reference to the RecipeAdapter
    RecipeAdapter adapter = new RecipeAdapter(store);

    // Have the RecyclerView use the adapter
    recyclerView.setAdapter(adapter);

    // Set a fixed size on the RecyclerView
    recyclerView.setHasFixedSize(true);

    // Provide a layoutManager for the RecyclerView to function
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }
}
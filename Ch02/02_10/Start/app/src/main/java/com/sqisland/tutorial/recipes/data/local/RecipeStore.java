package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.sqisland.tutorial.recipes.data.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeStore {
    public final List<Recipe> recipes = new ArrayList<>();

    // Create an empty Map object
    private final Map<String, Recipe> map = new HashMap<>();

    public RecipeStore(Context context, String directory) {
      List<InputStream> streams = getAssetStreams(context.getAssets(), directory);

      for (InputStream stream : streams) {
          Recipe recipe = Recipe.readFromStream(stream);
          if (recipe != null) {
              recipes.add(recipe);

              // Add the Recipe to the Map
              // The key is the Recipe's id, and the
              // value is the actual Recipe.
              map.put(recipe.id, recipe);
          }
      }
    }

    private static List<InputStream> getAssetStreams(AssetManager manager, String directory) {
      String[] filenames = getFilenames(manager, directory);

      List<InputStream> streams = new ArrayList<>();
      for (String filename : filenames) {
          File file = new File(directory, filename);
          try {
              InputStream stream = manager.open(file.getPath());
              if (stream != null) {
                  streams.add(stream);
              }
          } catch (IOException e) {
          }
      }

      return streams;
    }

    private static String[] getFilenames(AssetManager manager, String directory) {
        if (directory == null) {
            return new String[0];
        }

        try {
            return manager.list(directory);
        } catch (IOException e) {
            return new String[0];
        }
    }

    // This test method retrieves a recipe by its ID
    public Recipe getRecipe(String id) {

        // Return the id of the Recipe
        return map.get(id);
    }
}

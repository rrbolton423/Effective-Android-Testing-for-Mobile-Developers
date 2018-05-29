package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.content.res.AssetManager;

import com.sqisland.tutorial.recipes.data.model.Recipe;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

// Create RecipeStore class
public class RecipeStore {

    // Declare an empty Recipe list field
    public final List<Recipe> recipes = new ArrayList<>();

    // Create constructor accepting context and directory
    public RecipeStore(Context context, String directory) {

        // Get a list of InputStreams for each Recipe
        List<InputStream> streams = getAssetStreams(context.getAssets(),
                directory);

        // Loop through the InputStreams
        for (InputStream stream: streams) {

            // Create a Recipe from each Stream
            Recipe recipe = Recipe.readFromStream(stream);

            // If the Recipe is not null...
            if (recipe != null) {

                // Add the Recipes to the list of Recipes
                recipes.add(recipe);
            }
        }
    }

    // Reads from the assets folder, and returns the list
    // of InputStreams
    private static List<InputStream> getAssetStreams
    (AssetManager manager, String directory) {

        // Declare an empty list of InputStreams
        List<InputStream> streams = new ArrayList<>();

        // Get the file names from the helper method
        String[] filenames = getFileNames(manager, directory);

        // Loop through the file name
        for (String filename : filenames) {

            // Make a file from the file name, plus the directory
            File file = new File(directory, filename);

            try {
                // Pass file to the AssetManager to get an input stream
                // and use that as the return value
                InputStream stream = manager.open(file.getPath());

                // If the stream is not null
                if (stream != null) {

                    // Add each stream to the StreamsList
                    streams.add(stream);
                }

            } catch (IOException e) { // IOException handle

                // Print the stack trace
                e.printStackTrace();
            }
        }

        // Return the list of InputStreams
        return streams;
    }

    // Finds all the files that contain the Recipes
    private static String[] getFileNames
    (AssetManager manager, String directory) {

        // If the directory is null...
        if (directory == null) {

            // Return an empty array
            return new String[0];
        }

        try {

            // Return the list of Strings that contains all the files
            return manager.list(directory);

        } catch (IOException e) { // IOException handle

            // Return an empty array
            return new String[0];
        }
    }
}

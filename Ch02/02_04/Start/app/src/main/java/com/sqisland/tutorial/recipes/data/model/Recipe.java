package com.sqisland.tutorial.recipes.data.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Recipe {

    // Create constant for prefix
    private static final String ID_PREFIX = "id=";
    private static final String TITLE_PREFIX = "title=";

    public final String id;
    public final String title;
    public final String description;

    private Recipe(String id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public static Recipe readFromStream(InputStream stream) {
        String id = null;
        String title = null;
        StringBuilder descBuilder = new StringBuilder();

        // Pass the stream to a BufferedReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

        try {
            // Read out of the Reader, line by line
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                // If the line starts with "id="...
                if (line.startsWith(ID_PREFIX)) {

                    // Skip the whole prefix and extract the rest of the line
                    id = line.substring(ID_PREFIX.length());

                    // End the current loop
                    continue;
                 }

                // If the line starts with "title="...
                if (line.startsWith(TITLE_PREFIX)) {

                    // Skip the whole prefix and extract the rest of the line
                    title = line.substring(TITLE_PREFIX.length());

                    // End the current loop
                    continue;
                }

                // If it is not the first line...
                if (descBuilder.length() > 0) {

                    // Add a new line
                    descBuilder.append("\n");
                }

                // Add the description
                descBuilder.append(line);
            }
        } catch (IOException e) {
            return null;
        }

        return new Recipe(id, title, descBuilder.toString());
    }

}

package com.sqisland.tutorial.recipes.data.model;

import java.io.InputStream;

// Create Recipe class
public class Recipe {

    // Create Recipe fields
    public final String id;
    public final String title;
    public final String description;

    // Create constructor
    private Recipe(String id, String title, String description) {
        // Save fields persistently
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Create method to read an input stream
    public Recipe readFromStream(InputStream stream) {
        return null;
    }
}

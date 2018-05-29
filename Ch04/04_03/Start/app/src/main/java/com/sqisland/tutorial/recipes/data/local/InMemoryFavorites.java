package com.sqisland.tutorial.recipes.data.local;

import java.util.HashMap;
import java.util.Map;

// Implement the Favorites interface as an in-memory structure
public class InMemoryFavorites implements Favorites{

    // Create a HashMap
    private final Map<String, Boolean> map = new HashMap<>();

    @Override
    public boolean get(String id) {

        // Get the favorite value of the Recipe
        Boolean value = map.get(id);

        // Return false if the value is null,
        // otherwise return the value itself
        return value == null ? false : value;
    }

    @Override
    public boolean toggle(String id) {

        // Retrieve the value from the map
        boolean value = map.get(id);

        // Put the negated value into the map
        map.put(id, !value);

        // Return the negated value
        return !value;
    }

    public void put(String id, boolean value) {

        // Put the value into our map
        map.put(id, value);
    }
}

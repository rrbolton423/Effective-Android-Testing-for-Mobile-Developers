package com.sqisland.tutorial.recipes.data.local;

// Create a Favorites interface
public interface Favorites {

    /*
    The functions below must be implemented
     */

    boolean get(String id);

    boolean toggle(String id);
}

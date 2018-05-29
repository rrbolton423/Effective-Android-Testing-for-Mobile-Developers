package com.sqisland.tutorial.recipes.data.local;

import android.content.Context;
import android.content.SharedPreferences;

// Create a SharedPrefs class
public class SharedPreferencesFavorites {

    // Create a SharedPrefs field
    private final SharedPreferences pref;

    // Create Constructor
    public SharedPreferencesFavorites(Context context) {

        // Initialize Prefs in Constructor
        // passing the name of the file, and the privacy mode
        pref = context.getSharedPreferences
                ("favorites.xml", Context.MODE_PRIVATE);
    }

    // get() retrieves what was previously stored
    public boolean get(String id) {

        // Returns the value of the favorite
        // Retrieve false if we don't find the id
        return pref.getBoolean(id, false);
    }

    // put() stores a new value
    public void put(String id, boolean favorite) {

        // Get a SharedPreferences Editor object and
        // edit the prefs object
        SharedPreferences.Editor editor = pref.edit();

        // If the value is a favorite...
        if (favorite) {

            // Store the value as true
            editor.putBoolean(id, true);

        } else { // If the value is NOT a favorite...

            // Remove the id from the Prefs altogether
            editor.remove(id);
        }

        // Save the changes
        editor.apply();
    }

    // toggle() retrieves the old value, and flips it from
    // true to false or false to true
    public boolean toggle(String id) {

        // Get the current value of the favorite
        // from the Recipe's id
        boolean favorite = get(id);

        // Store the opposite value
        put(id, !favorite);

        // Return the opposite value
        return !favorite;

    }
}

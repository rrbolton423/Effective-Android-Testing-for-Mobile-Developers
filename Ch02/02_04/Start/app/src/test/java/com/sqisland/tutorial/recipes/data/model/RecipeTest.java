package com.sqisland.tutorial.recipes.data.model;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class RecipeTest {
  @Test
  public void water() {
      InputStream stream = RecipeTest.class.getResourceAsStream("/recipes/water.txt");
      Recipe recipe = Recipe.readFromStream(stream);
      assertNotNull(recipe);

      // Assert the id of the Recipe
      assertEquals("water", recipe.id);

      // Assert the title of the Recipe
      assertEquals("Water", recipe.title);

      // Assert the description of the Recipe
      assertEquals("Put glass under tap. Open tap. Close tap. Drink.", recipe.description);
  }
}
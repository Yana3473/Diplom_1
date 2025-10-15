package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili", 100);
        assertEquals("chili", ingredient.getName());
    }

    @Test
    public void testGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 200.5f);
        assertEquals(200.5f, ingredient.getPrice(), 0.001);
    }

    @Test
    public void testGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 50);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
}

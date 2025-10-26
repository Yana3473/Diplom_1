package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;
    private Bun bunMock;
    private Ingredient sauceMock;
    private Ingredient fillingMock;

    @Before
    public void setup() {
        burger = new Burger();
        bunMock = mock(Bun.class);
        sauceMock = mock(Ingredient.class);
        fillingMock = mock(Ingredient.class);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(sauceMock.getName()).thenReturn("hot sauce");
        when(sauceMock.getPrice()).thenReturn(50f);
        when(sauceMock.getType()).thenReturn(IngredientType.SAUCE);

        when(fillingMock.getName()).thenReturn("cutlet");
        when(fillingMock.getPrice()).thenReturn(150f);
        when(fillingMock.getType()).thenReturn(IngredientType.FILLING);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        assertEquals("black bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(sauceMock);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);
        burger.moveIngredient(0, 1);
        assertEquals("hot sauce", burger.ingredients.get(1).getName());
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);
        float price = burger.getPrice();
        assertEquals(100*2 + 50 + 150, price, 0.001);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bunMock);
        burger.addIngredient(sauceMock);
        burger.addIngredient(fillingMock);

        String expectedReceipt =
                "(==== black bun ====)\n" +
                        "= sauce hot sauce =\n" +
                        "= filling cutlet =\n" +
                        "(==== black bun ====)\n\n" +
                        "Price: 400,000000\n";

        String actualReceipt = burger.getReceipt();

        // Убираем возможные различия
        expectedReceipt = expectedReceipt.replace("\r", "").trim();
        actualReceipt = actualReceipt.replace("\r", "").trim();

        assertEquals(expectedReceipt, actualReceipt);
    }

}


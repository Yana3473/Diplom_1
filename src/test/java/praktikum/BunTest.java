package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void testGetName() {
        Bun bun = new Bun("white bun", 100);
        assertEquals("white bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 150.5f);
        assertEquals(150.5f, bun.getPrice(), 0.001);
    }
}


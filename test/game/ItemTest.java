package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Item item;
    Item food;

    @BeforeEach
    void setUp() {
        item = new Item("kamen", "Kámen", "Těžký kámen", "nástroj");
        food = new Item("jablko", "Jablko", "Červené jablko", "jidlo");
    }

    @Test
    void testGetters() {
        assertEquals("kamen", item.getId());
        assertEquals("Kámen", item.getName());
        assertEquals("Těžký kámen", item.getDescription());
        assertEquals("nástroj", item.getType());
    }

    @Test
    void testIsEdible() {
        assertFalse(item.isEdible());
        assertTrue(food.isEdible());
    }
}

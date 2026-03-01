package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    Inventory inventory;
    Item item1;
    Item item2;

    @BeforeEach
    void setUp() {
        inventory = new Inventory(2);
        item1 = new Item("klic", "Klíč", "Starý klíč", "nástroj");
        item2 = new Item("mapa", "Mapa", "Mapa lesa", "nástroj");
    }

    @Test
    void testAddAndCapacity() {
        assertTrue(inventory.add(item1));
        assertTrue(inventory.add(item2));

        Item item3 = new Item("lano", "Lano", "Dlouhé lano", "nástroj");
        assertFalse(inventory.add(item3)); // Kapacita překročena
    }

    @Test
    void testGetAndRemove() {
        inventory.add(item1);
        assertEquals(item1, inventory.get("klic"));
        assertTrue(inventory.hasItem("klic"));

        Item removed = inventory.remove("klic");
        assertEquals(item1, removed);
        assertFalse(inventory.hasItem("klic"));
    }
}

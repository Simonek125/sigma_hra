package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    Room room1;
    Room room2;

    @BeforeEach
    void setUp() {
        room1 = new Room("Les", "Tmavý les");
        room2 = new Room("Jeskyně", "Temná jeskyně");
    }

    @Test
    void testExits() {
        room1.addExit("sever", room2);
        assertEquals(room2, room1.getExit("sever"));
        assertNull(room1.getExit("jih"));
    }

    @Test
    void testItems() {
        Item item = new Item("kamen", "Kámen", "Obyčejný kámen", "nástroj");
        room1.addItem(item);

        assertTrue(room1.getInventory().hasItem("kamen"));

        Item removed = room1.removeItem("kamen");
        assertEquals(item, removed);
        assertFalse(room1.getInventory().hasItem("kamen"));
    }
}

package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Player player;
    Room room;

    @BeforeEach
    void setUp() {
        room = new Room("Start", "Starting Room");
        player = new Player("Hero", room);
    }

    @Test
    void testGetRoom() {
        assertEquals(room, player.getCurrentRoom());
    }

    @Test
    void testMove() {
        Room nextRoom = new Room("Next", "Next Room");
        player.move(nextRoom);
        assertEquals(nextRoom, player.getCurrentRoom());
        assertNotEquals(room, player.getCurrentRoom());
    }
}
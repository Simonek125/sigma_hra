package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NPCTest {

    NPC npc;
    NPC silentNpc;

    @BeforeEach
    void setUp() {
        npc = new NPC("obchodnik", "Obchodník", "Stary muž", "člověk", "Vítej u mě!");
        silentNpc = new NPC("pes", "Pes", "Toulavý pes", "zvíře", "");
    }

    @Test
    void testGetters() {
        assertEquals("obchodnik", npc.getId());
        assertEquals("Obchodník", npc.getName());
        assertEquals("Stary muž", npc.getDescription());
    }

    @Test
    void testTalk() {
        assertEquals("Vítej u mě!", npc.talk());
        assertEquals("Hmmm...", silentNpc.talk());
    }
}

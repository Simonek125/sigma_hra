package game;

import java.util.Map;
import java.util.List;

public class Room {
    private String name;
    private String description;
    private Map<String, Room> exits;
    private Inventory items;
    private List<NPC> npcs;

    public Room(String name, String description) {

    }

    public void addExit(String direction, Room room) {

    }

    public Room getExit(String direction) {
        return null;
    }

    public void addItem(Item item) {

    }

    public Item removeItem(String itemName) {
        return null;
    }

    public void addNPC(NPC npc) {

    }

    public NPC getNPC(String name) {
        return null;
    }

    public String getLongDescription() {
        return null;
    }

    public String getName() {
        return null;
    }
}

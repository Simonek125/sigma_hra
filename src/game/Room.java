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
        this.name = name;
        this.description = description;
        this.exits = new java.util.HashMap<>();
        this.items = new Inventory(10); // Default capacity
        this.npcs = new java.util.ArrayList<>();
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public NPC getNPC(String name) {
        for (NPC npc : npcs) {
            if (npc.getName().equals(name))
                return npc;
        }
        return null;
    }

    public String getLongDescription() {
        return "Jsi v: " + name + "\n" + description + "\nVychody: " + exits.keySet();
    }

    public String getName() {
        return name;
    }
}

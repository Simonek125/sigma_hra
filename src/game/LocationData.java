package game;

import java.util.List;

public class LocationData {
    private String id;
    private String name;
    private String description;
    private List<String> neighbors;
    private List<ItemData> items;
    private List<NPCData> characters;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getNeighbors() {
        return neighbors;
    }

    public List<ItemData> getItems() {
        return items;
    }

    public List<NPCData> getCharacters() {
        return characters;
    }
}

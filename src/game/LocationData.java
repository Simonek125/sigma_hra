package game;

import java.util.List;

public class LocationData {
    private String id;
    private String name;
    private String description;
    private List<String> neighbors;
    private List<ItemData> items;
    private List<NPCData> characters;

    /** @return ID místnosti */
    public String getId() {
        return id;
    }

    /** @return Název místnosti */
    public String getName() {
        return name;
    }

    /** @return Popis místnosti */
    public String getDescription() {
        return description;
    }

    /** @return Seznam ID sousedních místností */
    public List<String> getNeighbors() {
        return neighbors;
    }

    /** @return Seznam dat o předmětech v místnosti */
    public List<ItemData> getItems() {
        return items;
    }

    /** @return Seznam dat o postavách v místnosti */
    public List<NPCData> getCharacters() {
        return characters;
    }
}

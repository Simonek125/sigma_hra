package game;

public class ItemData {
    private String id;
    private String name;
    private String description;
    private String type;

    /** @return Jedinečné ID předmětu */
    public String getId() {
        return id;
    }

    /** @return Název předmětu pro zobrazení hráči */
    public String getName() {
        return name;
    }

    /** @return Popis předmětu */
    public String getDescription() {
        return description;
    }

    /** @return Typ předmětu (např. 'jidlo', 'nastroj') */
    public String getType() {
        return type;
    }
}

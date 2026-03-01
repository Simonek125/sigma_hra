package game;

public class Item {
    private String id;
    private String name;
    private String description;
    private String type;
    private boolean isEdible;
    private boolean isHeavy;

    /**
     * Vytvoří nový předmět pro herní svět.
     * 
     * @param id          Jedinečné ID předmětu
     * @param name        Název předmětu
     * @param description Popis předmětu
     * @param type        Typ předmětu (např. "jidlo")
     */
    public Item(String id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;

        this.isEdible = "jidlo".equals(type); // Pokud má typ jídlo, je jedlý
        this.isHeavy = false;
    }

    /** @return Jedinečné ID předmětu */
    public String getId() {
        return id;
    }

    /** @return Uživatelsky přívětivý název předmětu */
    public String getName() {
        return name;
    }

    /** @return Popis předmětu */
    public String getDescription() {
        return description;
    }

    /** @return Typ předmětu (např. "nastroj", "jidlo") */
    public String getType() {
        return type;
    }

    /** @return Skutečnost, zda je předmět jedlý */
    public boolean isEdible() {
        return isEdible;
    }

    /** @return Skutečnost, zda je předmět těžký (a nelze ho sebrat) */
    public boolean isHeavy() {
        return isHeavy;
    }
}

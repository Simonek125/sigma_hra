package game;

public class Item {
    private String id;
    private String name;
    private String description;
    private String type;
    private boolean isEdible;
    private boolean isHeavy;

    public Item(String id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;

        this.isEdible = "jidlo".equals(type);
        this.isHeavy = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public boolean isEdible() {
        return isEdible;
    }

    public boolean isHeavy() {
        return isHeavy;
    }
}

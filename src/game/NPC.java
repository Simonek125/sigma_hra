package game;

public class NPC {
    private String id;
    private String name;
    private String description;
    private String type;
    private String dialog;
    private Item wantedItem;
    private Item rewardItem;

    public NPC(String id, String name, String description, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String talk() {
        if (dialog != null)
            return dialog;
        return "Hmmm...";
    }

    public void trade(Player player) {

        System.out.println(name + " nema nic na vymenu.");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

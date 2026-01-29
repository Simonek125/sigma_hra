package game;

public class Player {
    private String name;
    private Room currentRoom;
    private Inventory backpack;
    private int saturation;
    private boolean isHibernating;

    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
        this.backpack = new Inventory(10); // Default size
    }

    public void move(Room nextRoom) {
        currentRoom = nextRoom;
    }

    public boolean takeItem(Item item) {
        return false;
    }

    public boolean dropItem(String itemName) {
        return false;
    }

    public void eat(Item item) {

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Inventory getInventory() {
        return null;
    }

    public String getCurrentStatus() {
        return null;
    }
}

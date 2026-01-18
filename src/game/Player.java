package game;

public class Player {
    private String name;
    private Room currentRoom;
    private Inventory backpack;
    private int saturation;
    private boolean isHibernating;

    public Player(String name, Room startRoom) {

    }

    public void move(Room nextRoom) {

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
        return null;
    }

    public Inventory getInventory() {
        return null;
    }

    public String getCurrentStatus() {
        return null;
    }
}

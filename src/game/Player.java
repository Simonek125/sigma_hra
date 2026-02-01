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

    public boolean takeItem(String itemName) {
        Item item = currentRoom.removeItem(itemName);
        if (item != null) {
            if (item.isHeavy()) {
                currentRoom.addItem(item); // Vratit zpet
                return false; // Prilis tezke
            }
            if (backpack.add(item)) {
                return true;
            } else {
                currentRoom.addItem(item); // Batoh je plny
                return false;
            }
        }
        return false;
    }

    public boolean dropItem(String itemName) {
        Item item = backpack.remove(itemName);
        if (item != null) {
            currentRoom.addItem(item);
            return true;
        }
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

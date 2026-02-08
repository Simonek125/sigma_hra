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
        this.backpack = new Inventory(10);
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

    public String eat(Item item) {
        if (item == null) {
            return "Co mam jist?";
        }
        if (!item.isEdible()) {
            return "To se neda jist!";
        }
        if (backpack.hasItem(item.getName())) { // Or take from room? Usually from inventory.
            backpack.remove(item.getName());
            saturation += 50; // Increase saturation
            if (saturation > 100)
                saturation = 100;
            return "Snedl jsi " + item.getName() + ". Tvoje sytost je " + saturation + "/100.";
        }
        return "Nemas to v batohu.";
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Inventory getInventory() {
        return backpack;
    }

    public int getSaturation() {
        return saturation;
    }

    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    public boolean isHibernating() {
        return isHibernating;
    }

    public void setHibernating(boolean hibernating) {
        isHibernating = hibernating;
    }

    public String getCurrentStatus() {
        return "Sytost: " + saturation + "/100. " + (isHibernating ? "Spis." : "Jsi vzhuru.");
    }
}

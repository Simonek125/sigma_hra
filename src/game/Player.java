package game;

public class Player {
    private String name;
    private Room currentRoom;
    private Inventory backpack;
    private int saturation;
    private boolean isHibernating;

    /**
     * Vytvoří nového hráče.
     * 
     * @param name      Jméno hráče
     * @param startRoom Počáteční místnost
     */
    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
        this.backpack = new Inventory(10); // Batoh s kapacitou 10
    }

    /**
     * Přesune hráče do další místnosti.
     * 
     * @param nextRoom Cílová místnost
     */
    public void move(Room nextRoom) {
        currentRoom = nextRoom;
    }

    /**
     * Hráč se pokusí vzít předmět z aktuální místnosti do batohu.
     * 
     * @param itemName Název předmětu
     * @return true, pokud se podařilo předmět sebrat, jinak false
     */
    public boolean takeItem(String itemName) {
        Item item = currentRoom.removeItem(itemName);
        if (item != null) {
            if (item.isHeavy()) {
                currentRoom.addItem(item); // Vratit zpet, je příliš těžký
                return false; // Prilis tezke
            }
            if (backpack.add(item)) {
                return true; // Přidáno do batohu úspěšně
            } else {
                currentRoom.addItem(item); // Batoh je plny, vrátit do místnosti
                return false;
            }
        }
        return false;
    }

    /**
     * Hráč položí předmět z batohu do aktuální místnosti.
     * 
     * @param itemName Název předmětu
     * @return true, pokud se předmět podařilo vyhodit
     */
    public boolean dropItem(String itemName) {
        Item item = backpack.remove(itemName);
        if (item != null) {
            currentRoom.addItem(item); // Vrátí předmět zpět do místnosti
            return true;
        }
        return false;
    }

    /**
     * Hráč sní předmět, aby si doplnil sytost.
     * 
     * @param item Předmět k jídlu
     * @return Zpráva o výsledku akce
     */
    public String eat(Item item) {
        if (item == null) {
            return "Co mam jist?";
        }
        if (!item.isEdible()) {
            return "To se neda jist!";
        }
        if (backpack.hasItem(item.getName())) { // Kontrola, zda je předmět v batohu
            backpack.remove(item.getName());
            saturation += 50; // Zvýšení sytosti po snězení
            if (saturation > 100)
                saturation = 100; // Sytost nemůže přesáhnout 100
            return "Snedl jsi " + item.getName() + ". Tvoje sytost je " + saturation + "/100.";
        }
        return "Nemas to v batohu.";
    }

    /** @return Aktuální místnost, ve které se hráč nachází */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /** @return Inventář (batoh) hráče */
    public Inventory getInventory() {
        return backpack;
    }

    /** @return Hodnota aktuální sytosti hráče */
    public int getSaturation() {
        return saturation;
    }

    /** Nastaví sytost hráče */
    public void setSaturation(int saturation) {
        this.saturation = saturation;
    }

    /** @return true, pokud hráč spí/hibernuje */
    public boolean isHibernating() {
        return isHibernating;
    }

    /** Nastaví stav hibernace hrace */
    public void setHibernating(boolean hibernating) {
        isHibernating = hibernating;
    }

    /** @return Textový stav hráče včetně sytosti a stavu bdělosti */
    public String getCurrentStatus() {
        return "Sytost: " + saturation + "/100. " + (isHibernating ? "Spis." : "Jsi vzhuru.");
    }

}

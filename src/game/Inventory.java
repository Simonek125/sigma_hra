package game;

import java.util.List;

public class Inventory {
    private List<Item> items;
    private int capacity;

    public Inventory(int capacity) {

    }

    public boolean add(Item item) {
        return false;
    }

    public Item remove(String name) {
        return null;
    }

    public Item get(String name) {
        return null;
    }

    public boolean hasItem(String name) {
        return false;
    }

    public String listItems() {
        return null;
    }

    public int size() {
        return 0;
    }
}

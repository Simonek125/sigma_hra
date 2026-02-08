package game;

import java.util.List;

public class Inventory {
    private List<Item> items;
    private int capacity;

    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new java.util.ArrayList<>();
    }

    public boolean add(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    public Item remove(String name) {
        Item item = get(name);
        if (item != null) {
            items.remove(item);
        }
        return item;
    }

    public Item get(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
            if (item.getId().equalsIgnoreCase(name)) {
                return item;
            }
        }
        for (Item item : items) {
            String lowercaseName = item.getName().toLowerCase();
            String lowercaseQuery = name.toLowerCase();
            if (lowercaseName.contains(lowercaseQuery)) {
                return item;
            }
        }
        return null;
    }

    public boolean hasItem(String name) {
        return get(name) != null;
    }

    public String listItems() {
        if (items.isEmpty()) {
            return "nic";
        }
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.getName()).append(" ");
        }
        return sb.toString().trim();
    }

    public int size() {
        return items.size();
    }

    public List<Item> getItems() {
        return items;
    }
}

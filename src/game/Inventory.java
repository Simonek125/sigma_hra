package game;

import java.util.List;

public class Inventory {
    private List<Item> items;
    private int capacity;

    /**
     * Konstruktor inventáře.
     * 
     * @param capacity Maximální počet předmětů, které může inventář obsahovat
     */
    public Inventory(int capacity) {
        this.capacity = capacity;
        this.items = new java.util.ArrayList<>();
    }

    /**
     * Přidá předmět do inventáře, pokud je v něm ještě místo.
     * 
     * @param item Předmět k přidání
     * @return true, pokud se přidání podařilo, jinak false
     */
    public boolean add(Item item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        return false;
    }

    /**
     * Odebere předmět z inventáře podle jeho jména.
     * 
     * @param name Jméno předmětu k odebrání
     * @return Odebíraný předmět, nebo null, pokud v inventáři není
     */
    public Item remove(String name) {
        Item item = get(name);
        if (item != null) {
            items.remove(item);
        }
        return item;
    }

    /**
     * Vyhledá předmět v inventáři.
     * Nejprve zkouší přesnou shodu se jménem a ID, poté částečnou shodu jména.
     * 
     * @param name Hledané jméno
     * @return Nalezený předmět, nebo null
     */
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
            // Pokud jméno obsahuje hledaný řetězec jako podřetězec
            if (lowercaseName.contains(lowercaseQuery)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Zkontroluje, zda inventář obsahuje předmět zadaného jména.
     * 
     * @param name Jméno předmětu
     * @return true, pokud jej má
     */
    public boolean hasItem(String name) {
        return get(name) != null;
    }

    /**
     * @return Textový výpis obsahu inventáře, odděleno mezerami.
     *         Vrací "nic", pokud je prázdný.
     */
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

    /** @return Počet předmětů v inventáři */
    public int size() {
        return items.size();
    }

    /** @return Seznam předmětů v inventáři */
    public List<Item> getItems() {
        return items;
    }
}

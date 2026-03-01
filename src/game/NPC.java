package game;

public class NPC {
    private String id;
    private String name;
    private String description;
    private String type;
    private String dialog;
    private Item wantedItem;
    private Item rewardItem;

    /**
     * Inicializuje novou postavu (NPC).
     * 
     * @param id          Identifikátor postavy
     * @param name        Jméno postavy
     * @param description Popis postavy
     * @param type        Typ postavy
     * @param dialog      Výchozí text, který postava řekne
     */
    public NPC(String id, String name, String description, String type, String dialog) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.dialog = dialog;
    }

    /**
     * Vrátí odpověď při promluvení na NPC.
     * 
     * @return Dialog nebo výchozí zamručení, pokud dialog chybí
     */
    public String talk() {
        if (dialog != null && !dialog.isEmpty()) {
            return dialog;
        }
        return "Hmmm...";
    }

    /**
     * Pokusí se s NPC provést nějaký obchod. Tady zatím prázdné varování.
     * 
     * @param player Hráč provádějící transakci
     */
    public void trade(Player player) {
        System.out.println(name + " nema nic na vymenu.");
    }

    /** @return ID postavy */
    public String getId() {
        return id;
    }

    /** @return Jméno postavy */
    public String getName() {
        return name;
    }

    /** @return Popis postavy */
    public String getDescription() {
        return description;
    }
}

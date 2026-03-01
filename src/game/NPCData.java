package game;

public class NPCData {
    private String id;
    private String name;
    private String description;
    private String type;
    private String dialog;

    /** @return Jedinečné ID postavy */
    public String getId() {
        return id;
    }

    /** @return Název postavy (např. "Jezevec") */
    public String getName() {
        return name;
    }

    /** @return Popis vzhledu nebo chování postavy */
    public String getDescription() {
        return description;
    }

    /** @return Druh postavy (např. 'zvíře') */
    public String getType() {
        return type;
    }

    /** @return Co postava řekne při použití příkazu mluv */
    public String getDialog() {
        return dialog;
    }
}

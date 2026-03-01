package game;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class GameData {
    private List<LocationData> locations;

    /** @return Seznam definovaných místností načtených z dat */
    public List<LocationData> getLocations() {
        return locations;
    }

    /**
     * Načte a deserializuje data ze souboru ve formátu JSON, ležícím v resource
     * balíčku.
     * Používá k tomu knihovnu Gson.
     * 
     * @param resourcePath Cesta k json souboru (např. "/gamedata.json")
     * @return Načtený objekt GameData obsahující mapu světa
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        Gson gson = new Gson();
        try (InputStream is = GameData.class.getResourceAsStream(resourcePath)) {
            if (is == null) {
                throw new IllegalStateException("Nenalezen resource: " + resourcePath);
            }
            return gson.fromJson(
                    new InputStreamReader(is, StandardCharsets.UTF_8),
                    GameData.class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }
}

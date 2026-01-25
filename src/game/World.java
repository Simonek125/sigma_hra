package game;

import java.util.HashMap;
import java.util.Map;

public class World {
    private Map<String, Room> rooms;

    public World() {
        rooms = new java.util.HashMap<>();
    }

    public void initWorld() {
        GameData data = GameData.loadGameDataFromResources("/gamedata.json");

        // 1. Create all rooms
        for (LocationData loc : data.getLocations()) {
            Room room = new Room(loc.getName(), loc.getDescription());
            rooms.put(loc.getId(), room);
        }

        // 2. Link neighbors
        for (LocationData loc : data.getLocations()) {
            Room currentRoom = rooms.get(loc.getId());
            if (loc.getNeighbors() != null) {
                for (String neighborId : loc.getNeighbors()) {
                    Room neighborRoom = rooms.get(neighborId);
                    if (neighborRoom != null) {
                        // Use the ID as the direction command (e.g., "jeskyne", "rozcesti")
                        currentRoom.addExit(neighborId, neighborRoom);
                    }
                }
            }
        }
    }

    public Room getRoom(String name) {
        return rooms.get(name);
    }
}

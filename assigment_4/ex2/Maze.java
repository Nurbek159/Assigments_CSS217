package ex2;

import java.util.HashMap;
import java.util.Map;

public class Maze {
    private Map<Integer, Room> rooms = new HashMap<Integer, Room>();

    public void addRoom (Room r) {
        rooms.put(r.getRoomNo(), r);
    }

    public Room roomNo (int r) {
        return rooms.get (r);
    }
}


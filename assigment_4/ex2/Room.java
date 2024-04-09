package ex2;

import ex2.Direction;
import ex2.Wall;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private Map<Direction, Wall> sides = new HashMap<Direction, Wall>();
    private int roomNo;

    public Room(int roomNo) {
        this.roomNo = roomNo;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public Wall getSide(Direction direction) {
        return sides.get(direction);
    }

    public void setSide(Direction direction, Wall wall) {
        sides.put(direction, wall);
    }

    /* ... */
}

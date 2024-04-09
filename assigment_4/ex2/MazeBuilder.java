package ex2;

import ex2.*;

public class MazeBuilder {
    private Maze maze;

    public MazeBuilder() {
        this.maze = new Maze();
    }

    public void addRoom(Room room) {
        maze.addRoom(room);
    }

    public void addWall(Room room, Direction direction) {
        Wall wall = new Wall();
        room.setSide(direction, wall);
    }

    public void addDoor(Room room1, Room room2) {
        DoorWall door = new DoorWall(room1, room2);
        room1.setSide(getDirection(room1, room2), door);
        room2.setSide(getDirection(room2, room1), door);
    }

    private Direction getDirection(Room fromRoom, Room toRoom) {

        int fromRoomNo = fromRoom.getRoomNo();
        int toRoomNo = toRoom.getRoomNo();
        if (toRoomNo - fromRoomNo == 1) {
            return Direction.EAST;
        } else if (toRoomNo - fromRoomNo == -1) {
            return Direction.WEST;
        } else if (toRoomNo > fromRoomNo) {
            return Direction.SOUTH;
        } else {
            return Direction.NORTH;
        }
    }

    public Maze build() {
        return maze;
    }
}


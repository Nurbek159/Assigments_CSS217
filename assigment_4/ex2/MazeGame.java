package ex2;

import ex2.Direction;
import ex2.Maze;
import ex2.Room;

public class MazeGame {
    public static void main(String[] args) {
        createMaze1();
        createMaze2();
    }

    private static void createMaze1() {
        MazeBuilder mazeBuilder = new MazeBuilder();

        Room r1 = new Room(1);
        Room r2 = new Room(2);

        mazeBuilder.addRoom(r1);
        mazeBuilder.addRoom(r2);

        mazeBuilder.addWall(r1, Direction.NORTH);
        mazeBuilder.addWall(r1, Direction.EAST);
        mazeBuilder.addWall(r1, Direction.SOUTH);
        mazeBuilder.addWall(r1, Direction.WEST);

        mazeBuilder.addWall(r2, Direction.NORTH);
        mazeBuilder.addWall(r2, Direction.EAST);
        mazeBuilder.addWall(r2, Direction.SOUTH);
        mazeBuilder.addWall(r2, Direction.WEST);

        mazeBuilder.addDoor(r1, r2);

        Maze maze1 = mazeBuilder.build();
    }

    private static void createMaze2() {
        MazeBuilder mazeBuilder = new MazeBuilder();

        Room r1 = new Room(1);
        Room r2 = new Room(2);
        Room r3 = new Room(3);

        mazeBuilder.addRoom(r1);
        mazeBuilder.addRoom(r2);
        mazeBuilder.addRoom(r3);

        mazeBuilder.addWall(r1, Direction.NORTH);
        mazeBuilder.addWall(r1, Direction.EAST);
        mazeBuilder.addWall(r1, Direction.SOUTH);
        mazeBuilder.addWall(r1, Direction.WEST);

        mazeBuilder.addWall(r2, Direction.NORTH);
        mazeBuilder.addWall(r2, Direction.EAST);
        mazeBuilder.addWall(r2, Direction.SOUTH);
        mazeBuilder.addWall(r2, Direction.WEST);

        mazeBuilder.addWall(r3, Direction.NORTH);
        mazeBuilder.addWall(r3, Direction.EAST);
        mazeBuilder.addWall(r3, Direction.SOUTH);
        mazeBuilder.addWall(r3, Direction.WEST);

        mazeBuilder.addDoor(r1, r2);
        mazeBuilder.addDoor(r2, r3);

        Maze maze2 = mazeBuilder.build();
    }
}

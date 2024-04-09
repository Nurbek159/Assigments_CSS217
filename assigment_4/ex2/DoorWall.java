package ex2;

public class DoorWall extends Wall {
    private Room r1;
    private Room r2;
    private boolean isOpen;

    public DoorWall (Room r1, Room r2) {
        this.r1 = r1;
        this.r2 = r2;
        this.isOpen = false;
    }
}

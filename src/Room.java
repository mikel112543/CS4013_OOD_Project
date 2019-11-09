import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String roomType;
    private int noOfRooms;
    public List<Room> fiveStar = new ArrayList<>();
    protected int noOfChildren;
    protected int noOfAdults = 1;

    public void setNoOfAdults(int noOfAdults) {
        this.noOfAdults = noOfAdults;
    }

    public int getNoOfAdults() {
        return noOfAdults;
    }

    public void setNoOfChildren(int noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public int getNoOfChildren() {
        return noOfChildren;
    }

    public Room(String roomType, int noOfAdults, int noOfChildren, boolean breakfast) {
        this.roomType = roomType;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;

    }

    public Room(String roomType, int noOfRooms) {
        this.roomType = roomType;
        this.noOfRooms = noOfRooms;
    }
}

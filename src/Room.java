import java.util.ArrayList;

public class Room {
    private String roomType;
    private int noOfRooms;
    protected double price;
    boolean breakfast = false;
    private int noOfChildren = 0;
    private int noOfAdults = 1;

    public Room() {
        roomType = "";
        noOfRooms = 0;
        noOfChildren = 0;
        noOfAdults = 1;
        breakfast = false;

    }

    public int getNoOfRooms() {
        return noOfRooms;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public double getPrice() {
        return price;
    }

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

    public Room(String roomType, int noOfRooms, int noOfAdults, int noOfChildren, boolean breakfast, double price) {
        this.roomType = roomType;
        this.noOfRooms = noOfRooms;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.breakfast =  breakfast;
        this.price = price;

    }

    public Room(String roomType, int noOfRooms) {
        this.roomType = roomType;
        this.noOfRooms = noOfRooms;
    }

    public void addBreakfast() {
        this.breakfast = true;
    }

    @Override
    public String toString() {
        return "Room{" +
                "Room Type: +" + this.roomType + '\'' +
                "Price: " + this.price +
                ", breakfast=" + this.breakfast +
                ", noOfChildren=" + this.noOfChildren +
                ", noOfAdults=" + this.noOfAdults +
                '}';
    }
}

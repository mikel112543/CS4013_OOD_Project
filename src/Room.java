import java.time.DayOfWeek;

public class Room {
    private String roomType;
    private int noOfRooms;
    protected int price;
    public boolean breakfast = false;
    private int noOfChildren = 0;
    private int noOfAdults = 1;
    private int noOfNights;
    private String hotelType;
    private DayOfWeek dayOfWeek;
    private String[] rooms = new String[]{"Deluxe Double", "Deluxe Twin", "Deluxe Single", "Deluxe Family", "Executive Double", "Executive Single", "Classic Double", "Classic Twin", "Classic Single"};
    private DayOfWeek[] days = new DayOfWeek[]{DayOfWeek.MONDAY,DayOfWeek.TUESDAY,DayOfWeek.WEDNESDAY,DayOfWeek.THURSDAY,DayOfWeek.FRIDAY,DayOfWeek.SATURDAY,DayOfWeek.SUNDAY};
    private int r;
    private int d;
    private int cost;
    private int[][] prices = new int[][]{
            {75, 75, 75, 80, 90, 90, 75},
            {75, 75, 75, 80, 90, 90, 75},
            {70, 70, 70, 75, 80, 80, 65},
            {80, 80, 80, 80, 100, 100, 80},
            {70, 70, 70, 70, 80, 85, 85},
            {70, 70, 70, 70, 80, 85, 85},
            {65, 65, 65, 65, 70, 75, 80},
            {65, 65, 70, 70, 75, 80, 65},
            {65, 65, 70, 70, 80, 85, 65},
            {50, 50, 50, 60, 75, 75, 50},
    };

    public Room(String roomType, int noOfAdults, int noOfChildren, boolean breakfast) {
        this.hotelType = hotelType;
        this.roomType = roomType;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.noOfNights = noOfNights;
        this.breakfast = breakfast;
    }

    public void setNoOfRooms(int noOfRooms) {
        this.noOfRooms = noOfRooms;
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

    public boolean isBreakfast() {
        return breakfast;
    }

    public void addBreakfast() {
        this.breakfast = true;
    }

    public int getRoomIndex(String room) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(room)) {
                r = i;
            }
        }
        return r;
    }

    public int getDayIndex(DayOfWeek day) {
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(day)) {
                d = i;
            }
        }
        return d;
    }

    public int getCostOneDay(String room, DayOfWeek day) {
        r = this.getRoomIndex(room);
        d = this.getDayIndex(day);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[i].length; j++) {
                cost = prices[r][d];
            }
        }
        return cost;
    }

    @Override
    public String toString() {
        return roomType + "\n" +
                "Adult Occupancy: " + noOfAdults + "\n" +
                "Child Occupancy: " + noOfChildren + "\n" +
                "Number of Nights: " + noOfNights + "\n" +
                "Breakfast: " + breakfast + "\n" +
                "Total price of room: " + getCostOneDay(roomType,dayOfWeek);
    }
}
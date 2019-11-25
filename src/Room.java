import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.text.Style;
import java.util.ArrayList;

public class Room {
    private String roomType;
    private int noOfRooms;
    protected int price;
    public boolean breakfast = false;
    private int noOfChildren = 0;
    private int noOfAdults = 1;
    private int noOfNights;
    private String hotelType;
    ReservationDate checkIn;
    private String dayOfWeek;
    private String[] daysOfWeek = new String[]{"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};


    public Room(String hotelType, String roomType, int noOfAdults, int noOfChildren, int noOfNights, boolean breakfast) {
        this.hotelType = hotelType;
        this.roomType = roomType;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.noOfNights = noOfNights;
        this.breakfast = breakfast;
    }

    public Room(String hotelType, String roomType, int noOfAdults, int noOfChildren, int noOfNights, boolean breakfast, int price, ReservationDate checkIn, String dayOfWeek) {
        this.hotelType = hotelType;
        this.roomType = roomType;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.noOfNights = noOfNights;
        this.breakfast = breakfast;
        this.price = price;
        this.checkIn = checkIn;
        this.dayOfWeek = dayOfWeek;
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

    public Room(String roomType, int noOfAdults, int noOfChildren, int noOfNights, boolean breakfast, int price, ReservationDate checkIn, String dayOfWeek) {
        this.roomType = roomType;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.noOfNights = noOfNights;
        this.breakfast = breakfast;
        this.price = price;
        this.checkIn = checkIn;
        this.dayOfWeek = dayOfWeek;

    }

    public Room(String roomType, int noOfRooms) {
        this.roomType = roomType;
        this.noOfRooms = noOfRooms;
    }

    public void addBreakfast() {
        this.breakfast = true;
    }

    public String getDayOfWeek(ReservationDate checkIn) {
        int day = (checkIn.getDay() + (26 * (checkIn.getMonth() + 1)) / 10 + (checkIn.getYear() % 100)
                + (checkIn.getYear() % 100) / 4 + (checkIn.getYear() / 100) / 4 + 5 * (checkIn.getYear() / 100)) % 7;
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (day == i) {
                dayOfWeek = daysOfWeek[i];
                return dayOfWeek;
            }
        }
        return "Not a date";
    }

    public int getPriceOfRoom(String roomType) {
        int[] deluxeDoubleDeluxeTwin = new int[]{90, 75, 75, 75, 75, 80, 90};
        int[] deluxeSingle = new int[]{80, 65, 70, 70, 70, 75, 80};
        int[] deluxeFamily = new int[]{100, 80, 80, 80, 80, 80, 100};
        int[] execDoubleExecTwin = new int[]{85, 85, 70, 70, 70, 70, 80};
        int[] execSingle = new int[]{75, 80, 65, 65, 65, 65, 70};
        int[] classicDouble = new int[]{80, 65, 65, 65, 70, 70, 75};
        int[] classicTwin = new int[]{85, 65, 65, 65, 70, 70, 80};
        int[] classicSingle = new int[]{75, 50, 50, 50, 50, 60, 75};
        int[] costForDaysOfTheWeek = new int[7];

        switch (roomType) {
            case "Deluxe Double":
            case "Deluxe Twin":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = deluxeDoubleDeluxeTwin[i];
                }
                break;
            case "Deluxe Single":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = deluxeSingle[i];
                }
                break;
            case "Deluxe Family":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = deluxeFamily[i];
                }
                break;
            case "Executive Double":
            case "Executive Twin":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = execDoubleExecTwin[i];
                }
                break;
            case "Executive Single":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = execSingle[i];
                }
                break;
            case "Classic Double":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = classicDouble[i];
                }
                break;
            case "Classic Twin":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = classicTwin[i];
                }
                break;
            case "Classic Single":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = classicSingle[i];
                }
                break;
        }
        for (int i = 0; i < daysOfWeek.length; i++) {
            if (daysOfWeek[i].equals(dayOfWeek)) {
                price = costForDaysOfTheWeek[i];
            }
        }
        return price;
    }

    @Override
    public String toString() {
        return roomType + "\n" +
                "Adult Occupancy: " + noOfAdults + "\n" +
                "Child Occupancy: " + noOfChildren + "\n" +
                "Number of Nights: " + noOfNights + "\n" +
                "Breakfast: " + breakfast + "\n" +
                "Total price of room: " + getPriceOfRoom(roomType);
    }
}

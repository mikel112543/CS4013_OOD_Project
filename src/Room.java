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
    ReservationDate checkIn;
    private String day;
    private String[] daysOfWeek = new String[] {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};


    public Room() {
        roomType = "";
        noOfRooms = 0;
        noOfChildren = 0;
        noOfAdults = 1;
        breakfast = false;

    }

    public Room(String roomType, int noOfAdults, int noOfChildren, int noOfNights, boolean breakfast) {
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

    public Room(String roomType, int noOfAdults, int noOfChildren, int noOfNights, boolean breakfast, int price, ReservationDate checkIn) {
        this.roomType = roomType;
        this.noOfAdults = noOfAdults;
        this.noOfChildren = noOfChildren;
        this.noOfNights = noOfNights;
        this.breakfast =  breakfast;
        this.price = price;
        this.checkIn = checkIn;

    }

    public Room(String roomType, int noOfRooms) {
        this.roomType = roomType;
        this.noOfRooms = noOfRooms;
    }

    public void addBreakfast() {
        this.breakfast = true;
    }

    public String getDayOfWeek(ReservationDate checkIn) {
        int dayOfWeek = (checkIn.getDay() + (26 * (checkIn.getMonth() + 1)) / 10 + (checkIn.getYear() % 100)
                + (checkIn.getYear() % 100) / 4 + (checkIn.getYear() / 100) / 4 + 5 * (checkIn.getYear() / 100)) % 7;
        for(int i = 0; i < daysOfWeek.length; i++) {
            if(dayOfWeek == i) {
                day = daysOfWeek[i];
                return day;
            }
        }
        return "Not a date";
    }

    public int getPriceOfRoom() {
        int[] deluxeDoubleDeluxeTwin = new int[] {75,75,75,80,90,90,75};
        int[] deluxeSingle = new int[] {70,70,70,75,80,80,65};
        int[] deluxeFamily = new int[] {80,80,80,80,100,100,80};
        int[] execDoubleExecTwin = new int[] {70,70,70,70,80,85,85};
        int[] execSingle = new int[] {65,65,65,65,70,75,80};
        int[] classicDouble = new int[] {65,65,70,70,75,80,65};
        int[] classicTwin = new int[] {65,65,70,70,80,85,65};
        int[] classicSingle = new int[] {50,50,50,60,75,75,50};
        String[] roomTypes = new String[] {"Deluxe Double" , "Deluxe Twin" , "Deluxe Single" , "Deluxe Family",
                                            "Executive Double" , "Executive Twin" , "Executive Single",
                                            "Classic Double" , "Classic Twin" , "Classic Single"};
        for(int i = 0; i < daysOfWeek.length; i++) {
            for(int j = 0; j < roomTypes.length; j++) {
                if(daysOfWeek[i].equals(day) && roomTypes[0].equals(roomType) || roomTypes[1].equals(roomType)) {
                    price = deluxeDoubleDeluxeTwin[i];
                    return price;
                }else if(daysOfWeek[i].equals(day) && roomTypes[2].equals(roomType)) {
                    price = deluxeSingle[i];
                    return price;
                }else if(daysOfWeek[i].equals(day) && roomTypes[3].equals(roomType)) {
                    price = deluxeFamily[i];
                    return price;
                }else if(daysOfWeek[i].equals(day) && roomTypes[4].equals(roomType) || roomTypes[5].equals(roomType)) {
                    price = execDoubleExecTwin[i];
                    return price;
                }else if(daysOfWeek[i].equals(day) && roomTypes[6].equals(roomType)) {
                    price = execSingle[i];
                    return price;
                }else if(daysOfWeek[i].equals(day) && roomTypes[7].equals(roomType)) {
                    price = classicDouble[i];
                    return price;
                }else if(daysOfWeek[i].equals(day) && roomTypes[8].equals(roomType)) {
                    price = classicTwin[i];
                    return price;
                }else if(daysOfWeek[i].equals(day) && roomTypes[9].equals(roomType)) {
                    price = classicSingle[i];
                    return price;
                }
            }
        }
        return price;
    }

    public int getTotalPrice(Room room) {
        //WEEKS
        String[] allRooms = new String[]{"Deluxe Double", "Deluxe Twin", "Deluxe Single", "Deluxe Family", "Executive Double", "Executive Twin", "Executive Single", "Classic Double", "Classic Twin", "Classic Single"};
        int[] costPerWeek = new int[]{560, 560, 510, 600, 530, 530, 485, 490, 500, 410};
        int costOfRoomPerWeek = 0;
        for (int i = 0; i < allRooms.length; i++) {
            String temp = allRooms[i];
            if (temp.equals(roomType)) {
                costOfRoomPerWeek = costPerWeek[i];
            }
        }
        int noOfWeeks = noOfNights / 7;
        int costForNumberOfWeeks = noOfWeeks * costOfRoomPerWeek;


        //DAYS
        int numberOfDays = noOfNights % 7;
        int costForNumberOfDays = 0;
        int costForOneRoom = 0;
        String[] daysOfTheWeek = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday", "mon", "tues", "wed", "thurs", "fri", "sat", "sun"};
        int[] costForDaysOfTheWeek = new int[13];
        //costs for each RoomType is assigned these values, then put into costForDaysOfTheWeek depending on which room it is
        int[] costForDaysDDandDT = new int[]{75, 75, 75, 80, 90, 90, 75, 75, 75, 75, 80, 90, 90, 75};
        int[] costForDaysDS = new int[]{70, 70, 70, 75, 80, 80, 65, 70, 70, 70, 75, 80, 80, 65};
        int[] costForDaysDF = new int[]{80, 80, 80, 80, 100, 100, 80, 80, 80, 80, 80, 100, 100, 80};
        int[] costForDaysEDandET = new int[]{70, 70, 70, 70, 80, 85, 85, 70, 70, 70, 70, 80, 85, 85};
        int[] costForDaysES = new int[]{65, 65, 65, 65, 70, 75, 80, 65, 65, 65, 65, 70, 75, 80};
        int[] costForDaysCD = new int[]{65, 65, 70, 70, 80, 85, 65, 65, 65, 70, 70, 80, 85, 65};
        int[] costForDaysCT = new int[]{65, 65, 70, 70, 80, 85, 65, 65, 65, 70, 70, 80, 85, 65};
        int[] costForDaysCS = new int[]{50, 50, 50, 60, 75, 75, 50, 50, 50, 50, 60, 75, 75, 50};
        switch (roomType) {
            case "Deluxe Double":
            case "Deluxe Twin":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysDDandDT[i];
                }
                break;
            case "Deluxe Single":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysDS[i];
                }
                break;
            case "Deluxe Family":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysDF[i];
                }
                break;
            case "Executive Double":
            case "Executive Twin":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysEDandET[i];
                }
                break;
            case "Executive Single":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysES[i];
                }
                break;
            case "Classic Double":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysCD[i];
                }
                break;
            case "Classic Twin":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysCT[i];
                }
                break;
            case "Classic Single":
                for (int i = 0; i < costForDaysOfTheWeek.length; i++) {
                    costForDaysOfTheWeek[i] = costForDaysCS[i];
                }
                break;
        }

        //this finds where to start on the daysOfTheWeek array.
        int b = 0; // b is the starting point
        for (int a = 0; a < daysOfTheWeek.length; a++) {
            if (daysOfTheWeek[a].equals(checkIn)) {
                b = a;
            }
        }
        int temp = numberOfDays;
        while (temp > 0) {
            int costOneDay = +costForDaysOfTheWeek[b];
            b++;
            temp--;
            costForNumberOfDays += costOneDay;
        }
        costForOneRoom = costForNumberOfDays + costForNumberOfWeeks;
        //totalCost += costForOneRoom;
        return costForOneRoom;
    }


    @Override
    public String toString() {
        return roomType + "\n" +
                "Adult Occupancy: " + noOfAdults + "\n" +
                "Child Occupancy: " + noOfChildren + "\n" +
                "Number of Nights: " + noOfNights + "\n" +
                "Breakfast: " + breakfast + "\n" +
                "Total price of room: " + getPriceOfRoom() + "\n";
    }
}

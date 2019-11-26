import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Customer {
    protected int resNumber;        //1
    protected String firstNameOnRes;//2
    protected String lastNameOnRes;
    protected String resType;       //3

    protected int year;             //4
    protected int month;
    protected int day;
    protected String checkInDay;
    protected String typeOfPurchase;

    protected int numberOfNights;   //5
    protected int numberOfRooms;    //6
    private int hotel;
    protected String roomType;    //7
    protected int adultOcc;
    protected int childOcc;
    protected boolean breakfast;
    protected int priceOfRoom;
    private String hotelType;
    private Reservation reservation;


    protected int totalCost;        //8
    protected int deposit;          //9

    public void getUserInput() throws FileNotFoundException {
        Menu menu = new Menu();
        ArrayList<Room> rooms = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.println("What is your first name?");
        firstNameOnRes = input.next();


        System.out.println("What is your last name?");
        lastNameOnRes = input.next();

        System.out.println("How many nights will you be staying for?");
        numberOfNights = input.nextInt();

        System.out.println("Year of Check-In?");
        year = input.nextInt();
        System.out.println("Month of Check-In? (1-12)");
        month = input.nextInt();
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            System.out.println("Day of Check-In? (1-30)");
        } else if (month == 2 && year % 4 == 0) {
            System.out.println("Day of Check-In? (1-29)");
        } else if (month == 2) {
            System.out.println("Day of Check-In? (1-28)");
        } else {
            System.out.println("Day of Check-In? (1-31)");
        }
        day = input.nextInt();
        if (month == 1 || month == 2) {
            month = (month == 1) ? 13 : 14;
            year--;
        }

        LocalDate checkIn =  LocalDate.of(year, month, day);

        System.out.println("How many rooms would you like to book?");
        numberOfRooms = input.nextInt();

        System.out.println("Select Star Hotel (5, 4, 3)");
        hotel = input.nextInt();
        if (hotel == 5) {
            hotelType = "Five Star";
        } else if (hotel == 4) {
            hotelType = "Four Star";
        } else if (hotel == 3) {
            hotelType = "Three Star";
        }

        String[] fiveStarHotel = new String []{"Deluxe Double" , "Deluxe Twin" , "Deluxe Single" , "Deluxe Family"};
        int[] fiveStarOccupancies = new int[]{35, 25, 10, 10};
        String[] fourStarHotel = new String[]{"Executive Double" , "Executive Twin" , "Executive Single"};
        int[] fourStarOccupancies = new int[]{40,32,12};
        String[] threeStarHotel = new String[]{"Classic Double" , "Classic Twin" , "Classic Single"};
        int[] threeStarOccupancies = new int[]{45,45,10};
        int i = 1;
        int typeOfRoom;
        while (i <= numberOfRooms) {
            System.out.println("Do you want breakfast for room " + i + "(Y/N)");
            String decision = input.next();
            breakfast = decision.equalsIgnoreCase("y");
            System.out.println("Select room type for room " + i);
            switch (hotel) {
                case 5:
                    for (int j = 0; j < fiveStarHotel.length; j++) {
                        System.out.print((j + 1)+ ")");
                        System.out.println(fiveStarHotel[j] +": Amount available = " + fiveStarOccupancies[j]);

                    }
                    typeOfRoom = input.nextInt();
                    fiveStarOccupancies[typeOfRoom]--;
                    switch (typeOfRoom) {
                        case 1:
                        case 2:
                        case 3:
                            occupancyDoubleSingleTwin(input, typeOfRoom);
                            roomType = fiveStarHotel[typeOfRoom - 1];
                            break;
                        default:
                            System.out.println("1 or 2 or 3 adults for this room");
                            adultOcc = input.nextInt();
                            System.out.println("1 or 0 children for this room");
                            childOcc = input.nextInt();
                            roomType = fiveStarHotel[typeOfRoom - 1];
                            break;
                    }
                    break;
                case 4:
                    for (int j = 0; j < fourStarHotel.length; j++) {
                        System.out.print((j + 1)+ ")");
                        System.out.println(fourStarHotel[j] +": Amount available = " + fourStarOccupancies[j-1]);
                    }
                    typeOfRoom = input.nextInt();
                    fourStarOccupancies[typeOfRoom]--;
                    occupancyDoubleSingleTwin(input, typeOfRoom);
                    roomType = fourStarHotel[typeOfRoom - 1];
                    break;
                default:
                    for (int j = 0; j < threeStarHotel.length; j++) {
                        System.out.print((j + 1)+ ")");
                        System.out.println(threeStarHotel[j] +": Amount available = " + threeStarOccupancies[j-1]);
                    }
                    typeOfRoom = input.nextInt();
                    threeStarOccupancies[typeOfRoom]--;
                    occupancyDoubleSingleTwin(input, typeOfRoom);
                    roomType = threeStarHotel[typeOfRoom - 1];
            }

            //checkInDay (eg mon), number of nights (eg 20), then get Cost of each room.
            //number of nights / 7 = number of weeks stayed.... numberOfWeeks x costOfOneWeek = costForAllWeeks.
            //number of nights % 7 = leftover days. ifCheckInDay is monday, go monday + leftoverDays.. eg if Monday and 6 leftOver is 2, monday + tuesday.
            Room room = new Room(roomType, adultOcc, childOcc, breakfast);
            rooms.add(room);
            i++;
            //method to add the rom into the arraylist of rooms with parameters being "roomType, adultOcc, childOcc, breakfast, cost";
        }
        System.out.println("Would you like to reserve this booking? your mother(Y / N) ");
        String reserve = input.next();
        System.out.println("What type of Reservation method will you be using? " + "\n S)Standard Booking" + "\n AP)Advanced Purchase");
        resType = input.next().toUpperCase();
        if (resType.equalsIgnoreCase("s")) {
            typeOfPurchase = "Standard Booking";
        }
        Reservation reservation = new Reservation(resNumber, firstNameOnRes, lastNameOnRes, hotelType, rooms, numberOfNights, checkIn, typeOfPurchase);
        reservation.makeReservation(reservation);


    }

    public void occupancyDoubleSingleTwin(Scanner input, int typeOfRoom) {
        switch (typeOfRoom) {
            case 1:
                System.out.println("2 or 1 adult for this room");
                adultOcc = input.nextInt();
                System.out.println("Room occupies zero children...");
                childOcc = 0;
                break;
            case 2:
                System.out.println("2 or 1 adult for this room");
                adultOcc = input.nextInt();
                System.out.println("1 or 0 children for this room");
                childOcc = input.nextInt();
                break;
            default:
                System.out.println("Room occupies 1 adult...");
                adultOcc = 1;
                System.out.println("1 or 0 children for this room");
                childOcc = input.nextInt();
                break;
        }
    }
}

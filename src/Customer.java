import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    protected  int priceOfRoom;

    protected int totalCost;        //8
    protected int deposit;          //9



    public void getUserInput(){

        ArrayList<Room> rooms = new ArrayList<>();


        Scanner input = new Scanner(System.in);
        System.out.println("M)ake Reservation   Q)uit");
        String choice = input.nextLine().toUpperCase();
        if (choice.equals("M")) {

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
            if(month == 4 || month == 6 || month == 9 || month ==11){
                System.out.println("Day of Check-In? (1-30)");
            }
            else if(month == 2 && year % 4 == 0){
                System.out.println("Day of Check-In? (1-29");
            }
            else if(month == 2 && year % 4 != 0){
                System.out.println("Day of Check-In? (1-28)");
            }
            else {
                System.out.println("Day of Check-In? (1-31");
            }
            day = input.nextInt();
            ReservationDate checkIn = new ReservationDate(day, month, year);

            if(month == 1 || month == 2){
                month = (month == 1) ? 13:14;
                year--;
            }
            int dayOfWeek = (day + (26 * (month + 1)) / 10 + (year % 100)
                    + (year % 100) / 4 + (year / 100) / 4 + 5 * (year / 100)) % 7;

            switch(dayOfWeek){
                case 0: checkInDay = ("Saturday"); break;
                case 1: checkInDay = ("Sunday"); break;
                case 2: checkInDay = ("Monday"); break;
                case 3: checkInDay = ("Tuesday"); break;
                case 4: checkInDay = ("Wednesday"); break;
                case 5: checkInDay = ("Thursday"); break;
                case 6: checkInDay = ("Friday"); break;
            }



            System.out.println("How many rooms would you like to book?");
            numberOfRooms = input.nextInt();


            System.out.println("Select Star Hotel (5, 4, 3)");
            hotel = input.nextInt();


            String[] fiveStarHotel = new String []{"Deluxe Double" , "Deluxe Twin" , "Deluxe Single" , "Deluxe Family"};
            String[] fourStarHotel = new String[]{"Executive Double" , "Executive Twin" , "Executive Single"};
            String[] threeStarHotel = new String[]{"Classic Double" , "Classic Twin" , "Classic Single"};

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
                            System.out.println(fiveStarHotel[j]);
                        }
                        typeOfRoom = input.nextInt();


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
                            System.out.println(fourStarHotel[j]);
                        }
                        typeOfRoom = input.nextInt();
                        occupancyDoubleSingleTwin(input, typeOfRoom);
                        roomType = fourStarHotel[typeOfRoom - 1];
                        break;
                    default:
                        for (int j = 0; j < threeStarHotel.length; j++) {
                            System.out.print((j + 1)+ ")");
                            System.out.println(threeStarHotel[j]);
                        }
                        typeOfRoom = input.nextInt();
                        occupancyDoubleSingleTwin(input, typeOfRoom);
                        roomType = threeStarHotel[typeOfRoom - 1];


                }

                //checkInDay (eg mon), number of nights (eg 20), then get Cost of each room.
                //number of nights / 7 = number of weeks stayed.... numberOfWeeks x costOfOneWeek = costForAllWeeks.
                //number of nights % 7 = leftover days. ifCheckInDay is monday, go monday + leftoverDays.. eg if Monday and 6 leftOver is 2, monday + tuesday.
                Room room = new Room(roomType, adultOcc, childOcc, numberOfNights, breakfast, priceOfRoom, checkIn, checkInDay);
                rooms.add(room);
                i++;
                //method to add the rom into the arraylist of rooms with parameters being "roomType, adultOcc, childOcc, breakfast, cost";
            }
            System.out.println("Would you like to reserve this booking? your mother(Y / N) ");
            String reserve = input.next();
            if (reserve.equalsIgnoreCase("y")) {
                System.out.println("What type of Reservation method will you be using? " + "\n S)Standard Booking" + "\n AP)Advanced Purchase");
                resType = input.next().toUpperCase();
                if(resType.equalsIgnoreCase("s")) {
                    typeOfPurchase = "Standard Booking";
                }
                Reservation reservation = new Reservation(resNumber, firstNameOnRes, lastNameOnRes, rooms, numberOfNights, checkIn, checkInDay, typeOfPurchase);
                reservation.addReservation(reservation);
            }else{
                getUserInput();
            }

        }else {
            System.out.println("Thank you for using L4 Hotels");
        }



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

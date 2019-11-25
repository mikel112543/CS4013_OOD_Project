import java.util.Scanner;
import java.util.*;
import java.util.ArrayList;

public class reservationUserInput{
    protected String nameReservation;
    protected String roomTypeReserved;
    protected int adultOcc;
    protected int childOcc;
    protected boolean breakfast;
    protected int numbOfRooms;
    protected String typeOfReservation;
    protected int numbOfNights;
    protected int reservationNumber;
    protected Date checkInDate;
    protected double resTotalCost;
    protected double resDeposit;
    protected ArrayList<Room> rooms = new ArrayList<>();



    public void getUserInput() {

        Scanner input = new Scanner(System.in);

        System.out.println("What name will be on the reservation?");
        nameReservation = input.next();

        System.out.println("How many rooms would you like to book?");
        numbOfRooms = input.nextInt();


        System.out.println("How many nights do you want the room/s for?");
        numbOfNights = input.nextInt();

        //System.out.println("What date would you like to book this room for?");



        int resNumber = 0;
        System.out.println("What type of reservation do you want to use" + "\n" + "S) Standard booking" + "\n" + "AP) Advanced purchase");
        typeOfReservation = input.next().toUpperCase();

        System.out.println("What type of Hotel do you want to be in?" + "\n" + "5)Star" + "\n" + "4)Star" + "\n" + "3)Star");
        int hotel = input.nextInt();

        int i = 1;

        System.out.println("What type of room do you want?" + "\n");
        int typeOfRoom = 0;
        String[] fiveStarHotel = (new String[]{"Deluxe Double" , "Deluxe Twin" , "Deluxe Single" , "Deluxe Family"});
        String[] fourStarHotel = (new String[]{"Executive Double" , "Executive Twin" , "Executive Single"});
        String[] threeStarHotel = (new String[]{"Classic Double" , "Classic Twin" , "Classic Single"});

        while (i <= numbOfRooms) {
            switch (hotel) {
                case 5:
                    System.out.println();
                    for (int j = 0; j <= fiveStarHotel.length; j++) {
                        roomTypeReserved = fiveStarHotel[j];
                        System.out.println((j + 1) + ")" + fiveStarHotel[j]);
                        typeOfRoom = input.nextInt();
                        switch (typeOfRoom) {
                            case 1:
                                System.out.println("How many adults will this occupy?(Max 2)");
                                adultOcc = input.nextInt();
                                System.out.println("This room occupies zero children.");
                                childOcc = 0;
                                break;
                            case 2:
                                System.out.println("How many adults will this occupy?(Max 2)");
                                adultOcc = input.nextInt();
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0)");
                                childOcc = input.nextInt();
                                break;
                            case 3:
                                System.out.println("This room has to occupy 1 adult");
                                adultOcc = 1;
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0)");
                                childOcc = input.nextInt();
                                break;
                            default:
                                System.out.println("How many adults will this occupy?(Max 3)");
                                adultOcc = input.nextInt();
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0");
                                childOcc = input.nextInt();
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.println();
                    for (int j = 0; j <= fourStarHotel.length; j++) {
                        System.out.println((j + 1) + ")" + fourStarHotel[j]);
                        roomTypeReserved = fourStarHotel[j];
                        typeOfRoom = input.nextInt();
                        switch (typeOfRoom) {
                            case 1:
                                System.out.println("How many adults will this occupy?(Max 2)");
                                adultOcc = input.nextInt();
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0)");
                                childOcc = input.nextInt();
                                break;
                            case 2:
                                System.out.println("This room has to occupy 1 adult");
                                adultOcc = 1;
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0)");
                                childOcc = input.nextInt();
                                break;
                            default:
                                System.out.println("How many adults will this occupy?(Max 3)");
                                adultOcc = input.nextInt();
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0");
                                childOcc = input.nextInt();
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println();

                    for (int j = 0; j <= threeStarHotel.length; j++) {
                        System.out.println((j + 1) + ")" + threeStarHotel[j]);
                        roomTypeReserved = threeStarHotel[j];
                        typeOfRoom = input.nextInt();
                        switch (typeOfRoom) {
                            case 1:
                                System.out.println("How many adults will this occupy?(Max 2)");
                                adultOcc = input.nextInt();
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0)");
                                childOcc = input.nextInt();
                                break;
                            case 2:
                                System.out.println("This room has to occupy 1 adult");
                                adultOcc = 1;
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0)");
                                childOcc = input.nextInt();
                                break;
                            default:
                                System.out.println("How many adults will this occupy?(Max 3)");
                                adultOcc = input.nextInt();
                                System.out.println("This room can occupy 1 child, do you wish to do so? (yes = 1, no = 0");
                                childOcc = input.nextInt();
                                break;
                        }
                    }
            }
            System.out.println("Would you like breakfast with this room? (Y for YES, N for No)");
            String line = input.nextLine();
            if(line.equalsIgnoreCase("y")) {
                breakfast = true;
            }else {
                breakfast = false;
            }
            Room room = new Room("double", adultOcc, childOcc, breakfast);






            //ResNumber     (j)    (reservationNumber)
            //ResName (I have)(nameReservation)
            //ResType (I have)(typeOfReservation)
            //ResCheckInDate (j) (checkInDate)
            //ResNumberNights (I have)(numbOfNights)
            //ResNumberOfRooms (I have)(numbOfRooms)
            //-> each room -> ResRoomType(I have)(roomTypeReserved)
            //             -> ResOccupancy(I have)(adult Occ, childOcc)
            //             -> ResBreakfast(I have)(breakfast)
            //ResTotalCost (j)
            //ResTotalDeposit(j)
            //RESERVE THE ROOM(int reservationNumber, String nameReservation, String typeOfReservation, Date checkInDate, int numbOfNights, int numbOfRooms,
        }


    }

}
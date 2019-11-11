import java.util.Scanner;

public class Customer {

    public String roomTypeRes;
    protected int adultOcc;
    protected int childOcc;
    protected String breakfast;

    public void reserveRoom() {  //public void customerMakesReservation

        Scanner input = new Scanner(System.in);
        Room room = new Room();


        System.out.println("How many rooms would you like to book?");
        int numbOfRooms = input.nextInt();
        int i = 1;

        int resNumber = 0;
        System.out.println("What type of reservation do you want to use" + "\n" + "S) Standard booking" + "\n" + "AP) Advanced purchase");
        String typeOfRes = input.next().toUpperCase();
        //every room in this reservation will be of type "S" or "AP".

        while (i <= numbOfRooms) {
            System.out.println("What type of room would you like for room " + i);
            System.out.println("1) Deluxe Double(2/0)" + "\n" + "2) Deluxe Twin(2/1)" + "\n" +
                    "3) Deluxe Single(1/1)" + "\n" + "4) Deluxe Family(3/1)" + "\n" + "5) Executive Double(2/0)" + "\n" + "6) Executive Twin(2/1)" + "\n" +
                    "7) Executive Single(1/1)" + "\n" + "8) Classic Double(2/0)" + "\n" + "9) Classic Twin(2/1)" + "\n" + "10) Classic Single(1/1)");

            int typeOfRoom = input.nextInt();

            if (typeOfRoom == 1) {
                roomTypeRes = "Deluxe Double";
                room.setRoomType(roomTypeRes);
                System.out.println("How many Adults will occupy this Deluxe Double room? (1, 2)");
                adultOcc = input.nextInt();
                room.setNoOfAdults(adultOcc);
                System.out.println("How many Children will occupy this Deluxe Double room? (0, 1)");
                childOcc = input.nextInt();
                room.setNoOfChildren(childOcc);
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                breakfast = input.next();
                if (breakfast.equalsIgnoreCase("Y")) {
                    room.addBreakfast();
                } else if (breakfast.equalsIgnoreCase("N")) {
                    room.breakfast = false;
                }
                System.out.println(room.toString());

                //reserveRoom(roomTypeRes, adultOcc, 0, breakfast, typeOfRes);
            } else if (typeOfRoom == 2) {
                roomTypeRes = "Deluxe Twin";
                System.out.println("How many Adults will occupy this Deluxe Twin room? (1, 2)");
                adultOcc = input.nextInt();
                room.setNoOfAdults(adultOcc);
                System.out.println("How many Children will occupy this Deluxe Twin room? (0, 1)");
                childOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                breakfast = input.next();
                //reserveRoom(roomTypeRes, adultOcc, childOcc, breakfast, typeOfRes);
            } else if (typeOfRoom == 3) {
                roomTypeRes = "Deluxe Single";
                System.out.println("How many Children will occupy this Deluxe Single room? (0, 1)");
                childOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                breakfast = input.next();
                //reserveRoom(roomTypeRes, 1, childOcc, breakfast, typeOfRes);
            } else if (typeOfRoom == 4) {
                roomTypeRes = "Deluxe Family";
                System.out.println("How many Adults will occupy this Deluxe Family room? (1, 2, 3)");
                adultOcc = input.nextInt();
                room.setNoOfAdults(adultOcc);
                System.out.println("How many children will occupy this Deluxe Family room? (0, 1)");
                childOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                breakfast = input.next();
                //reserveRoom(roomTypeRes, adultOcc, childOcc, breakfast, typeOfRes);
            } else if (typeOfRoom == 5) {
                roomTypeRes = "Executive Double";
                System.out.println("How many Adults will occupy this Executive Double room? (1, 2)");
                adultOcc = input.nextInt();
                room.setNoOfAdults(adultOcc);
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                breakfast = input.next();
                //reserveRoom(roomTypeRes, adultOcc, 0, breakfast, typeOfRes);
            } else if (typeOfRoom == 6) {
                roomTypeRes = "Executive Twin";
                System.out.println("How many Adults will occupy this Executive Twin room? (1, 2)");
                adultOcc = input.nextInt();
                room.setNoOfAdults(adultOcc);
                System.out.println("How many Children will occupy this Executive Twin room? (0, 1)");
                childOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                String breakfast = input.next();
                //reserveRoom(roomTypeRes, adultOcc, childOcc, breakfast, typeOfRes);
            } else if (typeOfRoom == 7) {
                roomTypeRes = "Executive Single";
                System.out.println("How many Children will occupy this Executive Single room? (0, 1)");
                int childOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                String breakfast = input.next();
                //reserveRoom(roomTypeRes, 1, childOcc, breakfast, typeOfRes);
            } else if (typeOfRoom == 8) {
                roomTypeRes = "Classic Double";
                System.out.println("How many Adults will occupy this Classic Double room? (1, 2)");
                int adultOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                String breakfast = input.next();
                //reserveRoom(roomTypeRes, adultOcc, 0, breakfast, typeOfRes);
            } else if (typeOfRoom == 9) {
                roomTypeRes = "Classic Twin";
                System.out.println("How many Adults will occupy this Classic Twin room? (1, 2)");
                adultOcc = input.nextInt();
                room.setNoOfAdults(adultOcc);
                System.out.println("How many Children will occupy this Classic Twin room? (0, 1)");
                childOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                breakfast = input.next();
                //reserveRoom(roomTypeRes, adultOcc, childOcc, breakfast, typeOfRes);
            } else if (typeOfRoom == 10) {
                roomTypeRes = "Classic Single";
                System.out.println("How many Adults will occupy this Classic Single room? (1, 2)");
                adultOcc = input.nextInt();
                room.setNoOfAdults(adultOcc);
                System.out.println("How many Children will occupy this Classic Single room? (0, 1)");
                childOcc = input.nextInt();
                System.out.println("Do you want breakfast in this room?" + "\n" + "Y) Yes" + "\n" + "N) No");
                breakfast = input.next();
                //reserveRoom(roomTypeRes, 1, childOcc, breakfast, typeOfRes);
            }
            i++;
        }

    }

    public void checkIn() {
        //run the method in the Hotel Desk Personnel class.
    }
}
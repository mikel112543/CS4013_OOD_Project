import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Reservation {
    protected int numberOfNights;
    private String checkInDay;
    protected double deposit;
    protected int totalPrice;
    protected int reservationNumber;
    protected String firstName;
    protected String lastName;
    protected String hotelType;
    protected String typeOfPurchase;
    private int sum = 0;
    protected LocalDate cancelDate;
    protected LocalDate checkIn;
    protected LocalDate checkOut;
    private DayOfWeek day;
    ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<String> days = new ArrayList<>();
    List<LocalDate> totalDates = new ArrayList<>();
    List<DayOfWeek> totalDays = new ArrayList<>();
    ArrayList<Integer> reservationNumbers = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    ArrayList<Reservation> cancellations = new ArrayList<>();

    public Reservation() {
    }

    public Reservation(int reservationNumber, String firstName, String lastName, String hotelType, ArrayList<Room> rooms, int numberOfNights, LocalDate checkIn, String typeOfPurchase) {
        this.reservationNumber = generateReservationNumber();
        this.firstName = firstName;
        this.lastName = lastName;
        this.hotelType = hotelType;
        this.rooms = rooms;
        this.numberOfNights = numberOfNights;
        this.checkIn = checkIn;
        this.typeOfPurchase = typeOfPurchase;
        this.checkOut = checkIn.plusDays(numberOfNights);
        totalPrice = calculateTotalPrice(rooms);
    }

    public void pickRooms(Room... room) {
        //rooms.add(Room);
    }

    public int generateReservationNumber() {
        reservationNumber = (int) (Math.random() * 1000000);
        for (int i = 0; i < reservationNumbers.size(); i++) {
            if (reservationNumbers.get(i) != reservationNumber) {
                reservationNumbers.add(reservationNumber);
            } else {
                reservationNumber = (int) (Math.random() * 1000000);
            }
        }
        return reservationNumber;
    }

    public double getDeposit() {
        deposit = totalPrice * 0.2;
        return deposit;
    }

    public String getHotelType() {
        return hotelType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public String getTypeOfPurchase() {
        return typeOfPurchase;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getCheckInDate() {
        return checkIn;
    }

    public String getName() {
        return firstName + " " + lastName;
    }


    public void showReservations() {
        for (Reservation r : reservations) {
            System.out.println(r.toString());
        }
    }

    public void makeReservation(Reservation reservation) throws FileNotFoundException {
        //Reservation reservation = new Reservation(firstName, lastName, hotelType, rooms, numberOfNights, checkIn, typeOfPurchase);
        reservations.add(reservation);
        reservation.saveReservation();
        System.out.println("Congratulations!" + "\n" + "You have booked " + rooms.size() + " rooms in " + hotelType + "" + " for " + this.numberOfNights + " nights." + "\n" +
                "Here are you're reservation details: " + "\n" + reservation);
        System.out.println("With a deposit of €" + reservation.getDeposit() + "\n" + "Your total payment is €" + totalPrice + "\n" +
                "Your reservation number is " + reservationNumber + reservation);
    }

    public void saveCancellation() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("Cancellations.csv", true);
        PrintWriter pw = new PrintWriter(fos);

        pw.println(this.getName() + "," + this.getReservationNumber() + "," + this.hotelType + "," + rooms.size() + "," + this.getNumberOfNights() + "," + this.getCheckInDate() + "," + getCheckOut() + "," + this.getDeposit() + "," + totalPrice);
        for (Room r : rooms) {
            pw.println(",,,,,,,,," + r.getRoomType() + "," + r.getNoOfAdults() + "," + r.getNoOfChildren() + "," + r.isBreakfast());
        }
    }

    public String roomInfo() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.toString());
        }
        return rooms.toString();
    }

    public void saveReservation() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("Reservations.csv", true);
        PrintWriter pw = new PrintWriter(fos);

        pw.println(this.getName() + "," + this.getReservationNumber() + "," + getHotelType() + "," + rooms.size() + "," + this.getNumberOfNights() + "," + this.getCheckInDate() + "," + getCheckOut() + "," + "S" + "," + this.getDeposit() + "," + totalPrice);
        for (int i = 0; i < rooms.size(); i++) {
            while (i < rooms.size()) {
                pw.println(",,,,,,,,,," + rooms.get(i).getRoomType() + "," + rooms.get(i).getNoOfAdults() + "," + rooms.get(i).getNoOfChildren() + "," + rooms.get(i).isBreakfast());
                i++;
            }
        }
        pw.close();
    }

    public void cancelReservation(Reservation reservation) throws FileNotFoundException {
        for (Reservation r : reservations) {
            reservations.remove(reservation);
            cancellations.add(reservation);
            r.saveCancellation();
            cancelDate = LocalDate.now();
            Period period = Period.between(cancelDate, checkIn);
            int diff = period.getDays();
            boolean moreThanDay = diff >= 1;
            if (moreThanDay) {
                System.out.println("Because this booking is not withing 24 hours of the check in date, you are entitled to a full refund.");
            } else {
                System.out.println("Refund not applicable because your check in date is in less than 24 hours, our apologies");
            }
        }
    }

    public int calculateTotalPrice(ArrayList<Room> rooms) {
        while (!checkIn.equals(checkOut)) {
            totalDates.add(checkIn);
            day = checkIn.getDayOfWeek();
            totalDays.add(day);
            checkIn = checkIn.plusDays(1);
        }
        for (Room r : rooms) {
            for (DayOfWeek d : totalDays) {
                sum += r.getCostOneDay(r.getRoomType(), d);
            }
        }
        totalPrice = sum;
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation Number: " + this.getReservationNumber() + "\n" +
                "Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
                "Hotel: " + this.getHotelType() + "\n" +
                "Number of nights: " + this.getNumberOfNights() + "\n" +
                "Check-In Date: " + this.getCheckInDate() + "\n" +
                "Check-Out Date: " + this.getCheckOut() + "\n" +
                "Reservation type: " + this.getTypeOfPurchase() + "\n" +
                "Total price: " + this.getTotalPrice() + "\n" +
                "Your room information is: " + "\n" + rooms;
    }
}

import java.text.SimpleDateFormat;
import java.util.*;

public class Reservation {
    protected ReservationDate checkIn;
    protected int numberOfNights;
    protected String checkInDay;
    protected double sum = 0;
    protected double totalPrice;
    protected double reservationNumber;
    protected String firstName;
    protected String lastName;
    protected Date checkInDate;
    protected String typeOfPurchase;
    protected int day, month, year;
    private final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Double> reservationNumbers = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    ArrayList<Reservation> cancellations = new ArrayList<>();


    public void pickRooms(Room... room) {
        //rooms.add(Room);
    }



    protected double getDeposit() {
        for (int i = 0; i < rooms.size(); i++) {
            //sum += (rooms.get(i));
        }
        double deposit = (sum) * (2 / 10);  //deposit is 20 percent room price
        return deposit;
    }

    public Reservation() {
    }


    public Reservation(int reservationNumber, String firstName, String lastName, ArrayList<Room> rooms, int numberOfNights, ReservationDate checkIn, String checkInDay, String typeOfPurchase) {
        this.reservationNumber = (int) (Math.random() * 1000000);
        this.firstName = firstName;
        this.lastName = lastName;
        this.rooms = rooms;
        this.numberOfNights = numberOfNights;
        this.checkIn = checkIn;
        this.checkInDay = checkInDay;
        this.typeOfPurchase = typeOfPurchase;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Congratulations! Thank you for making a booking with L4 Hotels.");
        System.out.println("Here are your reservation details: ");
        System.out.println(reservation);
        rooms.clear();
    }

    public void cancelReservation(Reservation reservation) {
        for (Reservation r : reservations) {
            reservations.remove(reservation);
            cancellations.add(reservation);
            Date cancelDate = new Date();
            boolean moreThanDay = Math.abs(checkInDate.getTime() - cancelDate.getTime()) > MILLIS_PER_DAY;
            if (moreThanDay) {
                System.out.println("Because this booking is not withing 24 hours of the check in date, you are entitled to a full refund.");
            } else {
                System.out.println("Refund not applicable because your check in date is in less than 24 hours, our apologies");
            }
            System.out.println("Your reservation for " + checkInDate + " has been cancelled.");
        }
    }

    public String roomInfo() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.toString());
        }
        return rooms.toString();
    }

    public double getReservationNumber() {
        return reservationNumber;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Reservation Number: " + reservationNumber + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Number of nights: " + numberOfNights + "\n" +
                "Check-In Date " + checkInDay + " " + checkIn + "\n" +
                "Reservation type: " + typeOfPurchase + "\n" +
                "Your room information is: " + "\n" + rooms;

    }
}

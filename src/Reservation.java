import java.text.SimpleDateFormat;
import java.util.*;

public class Reservation {
    protected int numberOfNights;
    protected double sum = 0;
    protected double totalPrice;
    protected double reservationNumber;
    protected String firstName;
    protected String lastName;
    protected Date checkInDate;
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

    public Reservation(String firstName, String lastName, int numberOfNights, int day, int month, int year) {
        Date reservationDate = new Date();
        this.day = day;
        this.month = month;
        this.year = year;
        checkInDate = new Date(year, month, day);
        this.firstName = firstName;
        this.lastName = lastName;
        this.numberOfNights = numberOfNights;
        for (int i = 0; i < reservationNumbers.size(); i++) {
            reservationNumber = (double) (Math.random() * 100000);
            if (reservationNumbers.contains(reservationNumber)) {
                reservationNumber = (double) (Math.random() * 100000);
            }
            reservationNumbers.add(reservationNumber);
        }
        for (int i = 0; i < rooms.size(); i++) {
            //sum += (rooms.getPrice()).get(i);
        }
        double numNightstotal = sum * numberOfNights;
        totalPrice = numberOfNights + this.getDeposit();
    }

    public void makeReservation(String firstName, String lastName, int numberOfNights, int day, int month, int year) {
        Reservation reservation = new Reservation(firstName, lastName, numberOfNights, day, month, year);
        reservations.add(reservation);
        System.out.println("Congratulations!" + "\n" + "You have booked " + rooms.size() + " rooms for " + numberOfNights + " nights."+"\n"+rooms.toString()+ "\n" + "You're checking in on " + checkInDate + ".");
        System.out.println("With a deposit of €" + reservation.getDeposit() + "\n" + "Your total payment is €" + totalPrice + "\n" + "Your reservation number is " + reservationNumber);
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
            System.out.println("Your reservation for "+checkInDate+" has been cancelled.");
        }
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

    public String getName(){
        return firstName+" "+lastName;
    }
}

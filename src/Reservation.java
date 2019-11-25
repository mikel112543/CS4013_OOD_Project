import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Reservation {
    protected int numberOfNights;
    protected int totalCost;
    protected double deposit;
    protected double sum = 0;
    protected double totalPrice;
    protected double reservationNumber;
    protected String firstName;
    protected String lastName;
    protected Date checkIn;
    protected Date checkOut;
    protected Calendar cancelDate;
    protected String typeOfPurchase;
    protected String hotelType;
    protected int day, month, year;
    private final static long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Double> reservationNumbers = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();
    ArrayList<Reservation> cancellations = new ArrayList<>();


    public void pickRooms(Room... room) {
        //rooms.add(Room);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }


    public Reservation() {
    }

    public Reservation(String firstName, String lastName, String hotelType, ArrayList<Room> rooms, int numberOfNights, Date checkIn, String typeOfPurchase) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hotelType = hotelType;
        this.rooms = rooms;
        this.numberOfNights = numberOfNights;
        this.typeOfPurchase = typeOfPurchase;
    }

    public void makeReservation(String firstName, String lastName, String hotelType, ArrayList<Room> rooms, int numberOfNights, Date checkIn, String typeOfPurchase) throws FileNotFoundException {
        Reservation reservation = new Reservation(firstName, lastName, hotelType, rooms, numberOfNights, checkIn, typeOfPurchase);
        reservations.add(reservation);
        reservation.saveReservation();
        System.out.println("Congratulations!" + "\n" + "You have booked " + rooms.size() + " rooms in "+hotelType+""+" for " + this.numberOfNights + " nights." + "\n" + rooms.toString() + "\n" + "You're checking in on " + checkIn.toString() + ".");
        System.out.println("With a deposit of €" + reservation.getDeposit() + "\n" + "Your total payment is €" + totalPrice + "\n" + "Your reservation number is " + reservationNumber + reservation);
    }


    public void cancelReservation(Reservation reservation) throws FileNotFoundException {
        for (Reservation r : reservations) {
            reservations.remove(reservation);
            cancellations.add(reservation);
            r.saveCancellation();
            cancelDate.setTime(new Date());
            //long difference = checkIn.getTimeInMillis() - cancelDate.getTimeInMillis();
            //boolean moreThanDay = difference > MILLIS_PER_DAY;
            /**if (moreThanDay) {
                System.out.println("Because this booking is not withing 24 hours of the check in date, you are entitled to a full refund.");
            } else {
                System.out.println("Refund not applicable because your check in date is in less than 24 hours, our apologies");
            }**/
        }
    }

    public double getReservationNumber() {
        return reservationNumber;
    }

    public String getHotelType() {
        return hotelType;
    }

    public double getDeposit() {
        deposit = totalCost * 0.2;
        return deposit;
    }

    public void saveReservation() throws FileNotFoundException {
                FileOutputStream fos = new FileOutputStream("Reservations.csv", true);
                PrintWriter pw = new PrintWriter(fos);

                pw.println(this.getName() + "," + this.getReservationNumber() + ","+getHotelType()+"," + rooms.size() + "," + this.getNumberOfNights() + "," + this.getCheckInDate() + "," + getCheckOut() + "," + "S" + "," + this.getDeposit() + "," + totalPrice);
                for(int i = 0; i < rooms.size(); i++ ) {
                    while (i < rooms.size()) {
                        pw.println(",,,,,,,,,," + rooms.get(i).getRoomType() + "," + rooms.get(i).getNoOfAdults() + "," + rooms.get(i).getNoOfChildren() + "," + rooms.get(i).isBreakfast());
                        i++;
                    }
                }
                pw.close();
            }

            public void saveCancellation() throws FileNotFoundException {
                FileOutputStream fos = new FileOutputStream("Cancellations.csv", true);
                PrintWriter pw = new PrintWriter(fos);

                //pw.println(this.getName() + "," + this.getReservationNumber()+","+this.hotelType+"," + rooms.size() + "," + this.getNumberOfNights() + "," + this.getCheckInDate() + "," + getCheckOut() + "," + this.getDeposit() + "," + totalPrice);
                for (Room r : rooms) {
                    pw.println(",,,,,,,,," + r.getRoomType() + "," + r.getNoOfAdults() + "," + r.getNoOfChildren() + "," + r.isBreakfast());
        }
    }

    public Date getCheckInDate() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Reservation Number: " + reservationNumber + "\n" +
                "Name: " + firstName + " " + lastName + "\n" +
                "Rooms reserved: " + rooms+"\n"+
                "Hotel: "+hotelType;

    }
}
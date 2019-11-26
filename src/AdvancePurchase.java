import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AdvancePurchase extends Reservation {
    private int totalPrice;
    private int standardPrice;
    private int reservationNumber;

    public AdvancePurchase(int reservationNumber, String firstName, String lastName, String hotelType, ArrayList<Room> rooms, int numberOfNights, LocalDate checkIn, String typeOfPurchase) {
        this.reservationNumber = generateReservationNumber();
        this.firstName = firstName;
        this.lastName = lastName;
        this.hotelType = hotelType;
        this.rooms = rooms;
        this.numberOfNights = numberOfNights;
        this.checkIn = checkIn;
        this.typeOfPurchase = typeOfPurchase;
        this.checkOut = checkIn.plusDays(numberOfNights);
        standardPrice = calculateTotalPrice(rooms);     //Full price excluding discount
        totalPrice = calculateDiscountPrice();          //Price when 5% discount is applied
    }

    public int getStandardPrice() {
        return standardPrice;
    }

    public int calculateDiscountPrice() {
        double discount = standardPrice * .05;
        totalPrice = (int) (standardPrice - discount);
        return totalPrice;
    }

    @Override
    public void makeReservation(Reservation reservation) throws FileNotFoundException {
        reservations.add(reservation);
        reservation.saveReservation();
        System.out.println("Congratulations!" + "\n" + "You have booked " + rooms.size() + " rooms in " + hotelType + "" + "for " + this.numberOfNights + " nights." + "\n" +
                "Here are you're reservation details: " + "\n" + reservation);
        System.out.println("With a deposit of €" + reservation.getDeposit() + "\n" + "Price was " + this.getStandardPrice() + "\n" + "With a 5% discount for purchasing in advance of your check in, your price is €" + this.calculateDiscountPrice() + "\n" + "Your reservation number is " + reservationNumber);
    }

    @Override
    public void cancelReservation(int reservationNumber) throws FileNotFoundException {
        for (Reservation r : reservations) {
            if(r.getReservationNumber() == reservationNumber) {
                reservations.remove(r);
                cancellations.add(r);
            }
            r.saveCancellation();
            System.out.println("Your reservation for " + checkIn + " has been cancelled.");
        }
    }

    @Override
    public void saveReservation() throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream("Reservations.csv", true);
        PrintWriter pw = new PrintWriter(fos);

        pw.println(this.getName() + "," + this.getReservationNumber() + "," + getHotelType() + "," + rooms.size() + "," + this.getNumberOfNights() + "," + this.getCheckInDate() + "," + getCheckOut() + "," + "AP" + "," + this.getDeposit() + "," + totalPrice);
        for (Room r : rooms) {
            pw.println(",,,,,,,,,," + r.getRoomType() + "," + r.getNoOfAdults() + "," + r.getNoOfChildren() + "," + r.isBreakfast());
        }
        pw.close();
    }

    @Override
    public String toString() {
        return "Reservation Number: " + this.getReservationNumber() + "\n" +
                "Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
                "Number of nights: " + this.getNumberOfNights() + "\n" +
                "Check-In Date: " + this.getCheckInDate() + "\n" +
                "Check-Out Date: " + this.getCheckOut() + "\n" +
                "Reservation type: " + this.getTypeOfPurchase() + "\n" +
                "Total price: " + this.getTotalPrice() + "\n" +
                "Your room information is: " + "\n" + rooms;
    }
}

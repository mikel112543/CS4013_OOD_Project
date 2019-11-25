import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;

public class AdvancePurchase extends Reservation {

    public AdvancePurchase(String firstName, String lastName, ArrayList<Room> rooms, int numberOfNights, Date checkIn, String typeOfPurchase) {
        Date reservationDate = new Date();
        this.day = day;
        this.month = month;
        this.year = year;
        this.checkIn = checkIn;
        checkIn = new Date(day, month, year);
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

    @Override
    public void makeReservation(String firstName, String lastName,String hotelType, ArrayList<Room> rooms, int numberOfNights, Date checkIn, String typeOfPurchase) throws FileNotFoundException {
        AdvancePurchase reservation = new AdvancePurchase(firstName, lastName, rooms, numberOfNights, checkIn, typeOfPurchase);
        reservations.add(reservation);
        double discounted = totalPrice * (19 / 20);
        reservation.saveReservation();
        System.out.println("Congratulations!" + "\n" + "You have booked " + rooms.size() + ", rooms for " + numberOfNights + " nights." + "\n" + "You're checking in on " + checkIn + ".");
        System.out.println("With a deposit of €" + reservation.getDeposit() + "\n" + "Your total payment would be €" + totalPrice + ". But with a 5% discount for purchasing in advance of your check in, your real price is €" + discounted + "\n" + "Your reservation number is " + reservationNumber);
    }

    @Override
    public void cancelReservation(Reservation reservation) {
        System.out.println("Cannot cancel, Advance Purchase");
    }
}

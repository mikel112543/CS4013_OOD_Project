import java.util.ArrayList;
import java.util.Date;

public class AdvancePurchase extends Reservation {

    public AdvancePurchase(int reservationNumber, String firstName, String lastName, ArrayList<Room> rooms, int numberOfNights, ReservationDate checkIn, String checkInDay, String typeOfPurchase) {
        this.reservationNumber = reservationNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rooms = rooms;
        this.numberOfNights = numberOfNights;
        this.checkIn = checkIn;
        this.checkInDay = checkInDay;
        this.typeOfPurchase = "AP";
    }
        /*for (int i = 0; i < reservationNumbers.size(); i++) {
            reservationNumber = (double) (Math.random() * 100000);
            if (reservationNumbers.contains(reservationNumber)) {
                reservationNumber = (double) (Math.random() * 100000);
            }
            reservationNumbers.add(reservationNumber);
        }
        for (int i = 0; i < rooms.size(); i++) {
            sum += (rooms.getPrice()).get(i);
        }
        double numNightstotal = sum * numberOfNights;
        totalPrice = numberOfNights + this.getDeposit();
    */


    @Override
    public void addReservation(Reservation reservation) {
        super.addReservation(reservation);
    }
}


    /*@Override
    public void addReservation(Reservation reservation){} {
        Reservation reservation = new AdvancePurchase(firstName, lastName, numberOfNights, day, month, year);
        reservations.add(reservation);
        double discounted = totalPrice * (19/20);
        System.out.println("Congratulations!" + "\n" + "You have booked " + rooms.size() + ", rooms for " + numberOfNights + " nights." + "\n" + "You're checking in on " + checkInDate + ".");
        System.out.println("With a deposit of €" + reservation.getDeposit() + "\n" + "Your total payment would be €" + totalPrice +". But with a 5% discount for purchasing in advance of your check in, your real price is €"+discounted+"\n" + "Your reservation number is " + reservationNumber);
    }

    @Override
    public void cancelReservation(Reservation reservation) {
        for (Reservation r : reservations) {
            reservations.remove(reservation);
            cancellations.add(reservation);
            System.out.println("Your reservation for "+checkInDate+" has been cancelled.");
        }
    */

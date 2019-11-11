import java.util.Date;

public class AdvancePurchase extends Reservation {
    @Override
    public void makeReservation(String firstName, String lastName, int numberOfNights, int day, int month, int year){} {
        Reservation reservation = new Reservation(firstName, lastName, numberOfNights, day, month, year);
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
    }
}

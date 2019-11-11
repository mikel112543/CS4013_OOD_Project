import java.util.Date;

public class AdvancePurchase extends Reservation {

    public AdvancePurchase(String firstName, String lastName, int numberOfNights, int day, int month, int year) {
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
            sum += (rooms.getPrice()).get(i);
        }
        double numNightstotal = sum * numberOfNights;
        totalPrice = numberOfNights + this.getDeposit();
    }

    @Override
    public void makeReservation(String firstName, String lastName, int numberOfNights, int day, int month, int year){} {
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
    }
}

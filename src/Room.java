import java.time.LocalDateTime;
import java.util.Scanner;

public class Room {
    private LocalDateTime checkInDate;
    protected String reservationName;
    protected int numberOfRooms;
    protected int reservationNumber;
    protected String reservationType;
    protected int adultOccupancy = 1;
    protected String roomType;
    protected int cost;
    protected static int deposit;
    Scanner reserveName = new Scanner(System.in);



    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }


}

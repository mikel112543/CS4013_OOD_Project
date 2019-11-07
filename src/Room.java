import java.time.LocalDateTime;

public class Room {
    private LocalDateTime checkInDate;
    protected String reservationName;
    protected int numberOfRooms;
    protected int reservationNumber;
    protected String reservationType;
    protected int adultOccupancy = 1;
    protected String roomType;
    protected int cost;
    protected int deposit;

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }
}

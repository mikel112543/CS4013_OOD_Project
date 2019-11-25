import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CSVtest {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Room> rooms = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Reservation res = new Reservation();
        Date checkIn = new Date(9,9,2012);
        res.makeReservation("John","Maguire",rooms,5,checkIn,"Type");
    }
}

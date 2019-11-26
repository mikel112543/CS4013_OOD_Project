import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
public class CreateSpreadSheet {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fos1 = new FileOutputStream("Reservations.csv",true);
        PrintWriter pw1 = new PrintWriter(fos1);

        pw1.println("Name, Reservation Number, Hotel, Number of rooms, Number of nights, Check in, Check out, S/AP, Deposit, Total cost, Room, Adults, Children, Breakfast Included");
        pw1.close();

        FileOutputStream fos2 = new FileOutputStream("Cancellations.csv",true);
        PrintWriter pw2 = new PrintWriter(fos2);

        pw2.println("Name, Reservation Number, Hotel, Number of rooms, Number of nights, Check in, Check out, Deposit, Total cost, Room, Adults, Children, Breakfast Included");
        pw2.close();

        System.out.println("Files created");
    }
}
/**
 * @author - Michael_Danaher - 18221726
 * @author - John_Maguire - 18250076
 * @author - Aaron_Foster - 18232086
 * @author - Ayoub_Jdair - 18266401
 */

import java.io.FileNotFoundException;

public class Simulation {
    public static void main(String[] args) throws FileNotFoundException {
        Reservation reservation = new Reservation();
        Menu menu = new Menu();
        menu.Run(reservation);
    }
}

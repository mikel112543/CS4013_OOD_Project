import java.util.Arrays;

public class RoomType extends Room {

    private Room[] fiveStar = {new Room("Deluxe Double", 35),
            new Room( "Deluxe Twin", 25),
            new Room("Deluxe Single", 10),
            new Room("Deluxe Family", 10)};

    private Room[] fourStar = {new Room("Executive Double", 40),
            new Room("Executive Twin", 32),
            new Room("Executive Single", 12)};

    public Room[] threeStar = {new Room("Classic Double", 45),
            new Room("Classic Twin", 45),
            new Room("Classic Single", 10)};

    public void showFiveStar() {
        for(int i = 0; i < fiveStar.length; i++) {
            System.out.println(Arrays.toString(fiveStar));
        }
    }

    public void showFourStar() {
        for(int i = 0; i < fourStar.length; i++) {
            System.out.println(Arrays.toString(fourStar));
        }
    }

    public void showThreeStar() {
        for(int i = 0; i < threeStar.length; i++) {
            System.out.println(Arrays.toString(threeStar));
        }
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "fiveStar=" + Arrays.toString(fiveStar) +
                ", fourStar=" + Arrays.toString(fourStar) +
                ", threeStar=" + Arrays.toString(threeStar) +
                '}';
    }
}

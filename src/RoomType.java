import java.util.Arrays;

public class RoomType extends Room {

    private Room[] fiveStar = {new Room("Deluxe Double", 35, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice()),
            new Room( "Deluxe Twin", 25, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice()),
            new Room("Deluxe Single", 10, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice()),
            new Room("Deluxe Family", 10, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice())};

    private Room[] fourStar = {new Room("Executive Double", 40, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice()),
            new Room("Executive Twin", 32, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice()),
            new Room("Executive Single", 12, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice())};

    public Room[] threeStar = {new Room("Classic Double", 45, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice()),
            new Room("Classic Twin", 45, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice()),
            new Room("Classic Single", 10, getNoOfAdults(), getNoOfChildren(), this.breakfast, getPrice())};

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
}
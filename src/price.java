public class price {
    private int[][] prices = new int[][]{
            {75, 75, 75, 80, 90, 90, 75},
            {75, 75, 75, 80, 90, 90, 75},
            {70, 70, 70, 75, 80, 80, 65},
            {80, 80, 80, 80, 100, 100, 80},
            {70, 70, 70, 70, 80, 85, 85},
            {70, 70, 70, 70, 80, 85, 85},
            {65, 65, 65, 65, 70, 75, 80},
            {65, 65, 70, 70, 75, 80, 65},
            {65, 65, 70, 70, 80, 85, 65},
            {50, 50, 50, 60, 75, 75, 50},
    };
    private String[] rooms = new String[]{"Delux Double", "Delux Twin", "Delux Single", "Delux Family", "Exectutive Double", "Executive Single", "Classic Double", "Classic Twin", "Classic Single"};
    private String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    private int r;
    private int d;
    private int cost;

    public int getRoomIndex(String room) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].equals(room)) {
                r = i;
            }
        }
        return r;
    }

    public int getDayIndex(String day) {
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(day)) {
                d = i;
            }
        }
        return d;
    }

    public int getCostOneDay(String room, String day) {
        r = this.getRoomIndex(room);
        d = this.getDayIndex(day);
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices[i].length; j++) {
                cost = prices[r][d];
            }
        }
        return cost;
    }
}

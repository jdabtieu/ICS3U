import java.util.*;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        System.out.print("Year: ");
        int y = in.nextInt();
        int m;
        int d;
        {
            int p = y / 100;
            int q = y - 19 * (y / 19);
            int r = (p - 17) / 25;
            int s = p - p / 4 - (p - r) / 3 + 19 * q + 15;
            s = s - 30 * (s / 30);
            s = s - (s / 28) * (1 - (s / 28) * (29 / (s + 1)) * ((21 - q) / 11));
            int t = y + y / 4 + s + 2 - p + p / 4;
            t = t - 7 * (t / 7);
            int u = s - t;
            m = 3 + (u + 40) / 44;
            d = u + 28 - 31 * (m / 4);
        }
        System.out.printf("%s %d, %d\n", months.get(m), d, y);
    }
    
    @SuppressWarnings("serial")
    static final HashMap<Integer, String> months = new HashMap<Integer, String>() {{
       put(1, "January");
       put(2, "February");
       put(3, "March");
       put(4, "April");
       put(5, "May");
       put(6, "June");
       put(7, "July");
       put(8, "August");
       put(9, "September");
       put(10, "October");
       put(11, "November");
       put(12, "December");
    }};
}

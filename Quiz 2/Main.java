import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        if (t < 0) {
            System.out.println("Ice");
        } else if (t == 0) {
            System.out.println("Ice + Water");
        } else if (t < 100) {
            System.out.println("Water");
        } else if (t == 100) {
            System.out.println("Water + Steam");
        } else {
            System.out.println("Steam");
        }
    }
}

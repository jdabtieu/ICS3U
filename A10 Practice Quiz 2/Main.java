import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your mark: ");
        int mark = in.nextInt();
        if (mark > 100 || mark < 0) {
            System.out.println("Invalid mark.");
            return;
        }
        char letter;
        if (mark >= 80) {
            letter = 'A';
        } else if (mark >= 70) {
            letter = 'B';
        } else if (mark >= 60) {
            letter = 'C';
        } else if (mark >= 50) {
            letter = 'D';
        } else {
            letter = 'F';
        }
        System.out.printf("Your mark is %c.\n", letter);
    }
}

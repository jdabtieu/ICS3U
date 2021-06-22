public class PracticeQuiz1 {
    public static void main(String[] args) {
        double candy = 0.50, chips = 1.50, pop = 1.00, fries = 4.25;
        double total = candy + chips + pop + fries;
        double tax = total * 0.13;
        //System.out.println(total + tax);
        System.out.printf("%.2f\n", total + tax);
    }
}

class Main {
    public static void main(String[] args) {
        // sum stores the sum of the numbers
        int sum = 0;

        // loop in the range [1, 100]
        for (int i = 1; i <= 100; i++) {
            // add i to the sum and also print it
            sum += i;
            System.out.println(i);

            // print a message if 50 is generated
            if (i == 50) {
                System.out.println("50 is detected");
            }
        }

        // print a message if sum is greater than 100
        if (sum > 100) {
            System.out.println("sum is greater than 100");
        }

        // print the sum
        System.out.println("sum is " + sum);
    }
}

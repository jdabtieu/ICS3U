class Main {
    public static void main(String[] args) {
        // Question 1
        {
            int num = 2;
            if (num > 0) {
                System.out.println("hello");
            }
        }

        // Question 2
        {
            int x = 20;
            int y = 1;
            if (x > Math.pow(y, 2)) {
                System.out.println("x is greater than y squared");
            }
        }

        // Question 3
        {
            int num = 3;
            if (num == 3) {
                System.out.println("goodbye");
            }
        }

        // Question 4
        {
            int num = 5;
            if (num > 3 && num < 10) {
                System.out.println("over here");
            }
        }

        // Question 5
        {
            int num = -1;
            if (num > 5 || num < 0) {
                System.out.println("up there");
            }
        }

        // Question 6
        {
            int grade = 100;
            if (grade >= 90) {
                System.out.println("Your grade is an A");
            } else if (grade >= 80) {
                System.out.println("Your grade is a B");
            } else {
                System.out.println("Your grade is a C or less");
            }
        }
    }
}

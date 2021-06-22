class Main {
    public static void main(String[] args) {
        double sum = 0;
        for (int i = 2; i <= 20; i++) {
            sum += (double) (i - 1) / i;
        }
        System.out.println(sum);

        int total = 0;
        for (int i = 0; i < 50; i++) {
            total += (i + 1) * (100 - 2 * i);
        }
        System.out.println(total);
    }
}

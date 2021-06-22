import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // Triple 1: 5, 12, 13
        // Triple 2: 7, 24, 25
        // Triple 3: 9, 40, 41
        int num = new Scanner(System.in).nextInt();
        for (int i = 3; i <= num; i++) {
            for (int j = 2; j < i; j++) {
                for (int k = 1; k < j; k++) {
                    if (k * k + j * j == i * i) {
                        System.out.printf("Found %d\u00b2 + %d\u00b2 = %d\u00b2\n", k, j, i);
                    }
                }
            }
        }
    }
}

// and here's a fun one-liner that also solves the problem
// class Main{public static void main(String[]args){for(int i=new java.util.Scanner(System.in).nextInt();i>=3;i--)for(int j=2;j<i;j++)for(int k=1;k<j;k++)if(k*k+j*j==i*i)System.out.printf("Found %d\u00b2 + %d\u00b2 = %d\u00b2\n", k, j, i);}}

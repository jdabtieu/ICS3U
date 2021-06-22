import java.util.Scanner; 


class Main {
  public static void main(String[] args) {


    Scanner sc=new Scanner(System.in); 
    System.out.println("Hello world!");

    //declaration - internally assign values to variables
    int heads=7;// 1. What is the type of the variable heads? int
    char first='A';// 2. What is the type of the variable first? char
    char second='M';// 3. What is the type of the variable second? char
    double headPercent;//4.  What is the type of the variable headPercent? double
    int total;// 5. What is the type of the variable total? int
    int tails=3;//6.  What is the type of the variable tails? int
    String s="string";

  

    //input from  keyboard
    System.out.println("How many times did you get heads?");//prompt 
    heads=sc.nextInt(); 

    System.out.println("How many times did you get tails?");    
    tails=sc.nextInt(); 

    System.out.println("Enter the First initial");   
    first=sc.next().charAt(0);

    System.out.println("Enter the second initial");   
    second=sc.next().charAt(0);
    //process calculation

    total=heads+tails;//7. What are the 3 identifiers in this statement? total, heads, tails
    headPercent=(double)heads/total;//8. What numerical value is stored in the variable headPercent based on the initial values? 0.7

    //output
    System.out.println(headPercent);
    System.out.println(first);
    System.out.println(second);
  }
}

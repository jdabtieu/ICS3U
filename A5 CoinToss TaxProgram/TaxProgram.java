import java.util.Scanner;

class Main
{
	public static void main(String[] args)
	{


    System.out.println("Ali's Store Program");
		//identifier declarations

    //0. What do we call types like double, int, float, boolean, byte and short? Primitive data types.
		final double TAX_RATE = 0.15;  // 1. What is the identifier? TAX_RATE
        
		double price;  //2. What is the variable? What is the identifier? What is the type? price, price, double
		double tax;    //3. What is the variable? What is the identifier? What is the type? tax, tax, double
		double total;  //4. What is the variable? What is the identifier? What is the type? total, total, double
		String item;   //5. What is the variable? What is the identifier of the variable? What is the type? item, item, String

		//create a Scanner object to read from the keyboard
		Scanner keyboard = new Scanner(System.in);

		//display prompts and get input
		System.out.print("Item description:  "); // prompt for item
		item = keyboard.nextLine(); // read & store item as entered by user
		System.out.print("Item price:  $"); // prompt for price
		price = keyboard.nextDouble(); // read & store price
		
		//calculations
		tax = price * TAX_RATE;     // 6. What value is stored into the variable tax? The product of 0.15 and user input, aka the total tax charged

		total = price + tax;     //7. What value is stored into the variable total? The sum of price and tax, aka the grand total
		
		//output results
		System.out.println("Item purchased: " + item);
    System.out.println("Price                 $" + price);
		System.out.println("Tax                   $" + tax);
		System.out.println("Total                 $" + total);
	}
}

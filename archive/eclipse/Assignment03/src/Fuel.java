import java.util.Scanner;
public class Fuel {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter the driving distance: ");
	
		double distance = kb.nextDouble();
		
		System.out.print("Enter kilos per liter: ");

		double kilos = kb.nextDouble();

		System.out.print("Enter price per liter: ");

		double price = kb.nextDouble();

		System.out.print("The cost of driving is $"+  (distance/kilos)*(price) ) ;
		
		

	}

}
	
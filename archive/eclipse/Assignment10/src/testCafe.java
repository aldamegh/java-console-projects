import java.util.Scanner;
public class testCafe {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		Cafe c1 = new Cafe();
		
		c1.setCoffeePrice(5.50);
		c1.setTeaPrice(3.50);
		c1.setDonutPrice(2.25);
		
		c1.setCoffeeTotQty(100);
		c1.setTeaTotQty(100);
		c1.setDonutTotQty(50);
		c1.setDiscount(10);
		
		
		int option;
		do { System.out.println("**********************************************************************\n" + 
				                "*               Welcome to Cafe :)                                   *\n" + 
				                "*               -------------------                                  *\n" + 
				                "*       Please enter one of the following options:                   *\n" + 
			                  	"*       1) order ==> this allows you to order a drink                *\n" + 
				                "*       2) quit ==> to end this program                              *\n" + 
			                 	"*                                                                    *\n" + 
				                "**********************************************************************");
				System.out.print("Enter your option :> ");
					option = kb.nextInt();
					if (option==1) {
						System.out.print("Please, enter order (#cups of coffee, #cups of tea and #donuts: ");
						int coffeeQty =kb.nextInt(); int teaQty= kb.nextInt();  int donutQty=kb.nextInt();
					 c1.order(coffeeQty, teaQty, donutQty);
						
					 c1.display(coffeeQty, teaQty, donutQty);
					}
					} while(option==1) ;
		
		System.out.println("Total sales = "+c1.getTotal());
		
		System.out.println("Thanks. Goodbye!");
	}

}

import java.util.Scanner;
public class discaond01 {
	  public static void main (String[]args) {
 
		  Scanner kb = new Scanner (System.in);
		  
		  System.out.print("Enter the priac: ");
		  
		  double price= kb.nextDouble();
		  
		  System.out.print("Enter the discaond: ");
		  
		  double dis = kb.nextDouble();
		  
		  System.out.println( "the discount is: "+(dis/100.0)*price +"$");
		  
		  System.out.print("the new price is: " + (price-(dis/100.0)*price) + "$" );
		 
		  
	
	
	
	
	
	
	
	
	
	
	
	
	  }	
}
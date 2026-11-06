import java.util.Scanner;

public class Numbers {
	public static void main(String[]args) {
		Scanner KB = new Scanner (System.in); 
		
		System.out.print("Enter theree numbers: ");
		
		int num1 = KB.nextInt() ;
		
	    int num2 = KB.nextInt()  ;

	    int num3 = KB.nextInt() ;
		
		int sum , mult  , power ;
		
		double average ;
		sum = num1 + num2 + num3 ;
		
		mult= num1 * num2 * num3 ;
		
		average= ((num1+num2+num3)/3.0); 
		 
		System.out.println("Sum = " + sum ) ;
		
		System.out.println("Mult = "+ mult);
		
		System.out.println("Avr = "+ average);
		
		System.out.println("Pow = "+ Math.pow(num1,num2));
		
		
		
	
	}
	

}

import java.util.Scanner; 
public class Shipping {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in) ;
		
		System.out.print("Enter package weight: ");

		
		int w = kb.nextInt();
		
		if( 0<w && w<=1 )
			System.out.print("The shipping cost is $3.5");
		else if (1<w && w<=3)
			System.out.print("The shipping cost is $5.5");
		else if (3<w && w<=10)
			System.out.print("The shipping cost is $8.5");
		else if (10<w && w<=20)
		System.out.print("The shipping cost is $10.5");
		else 
			System.out.print("The package cannot be shipped.");
			
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

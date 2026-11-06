import java.util.Scanner;
public class Triangle {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter three edges (length in double): ");
		
		double A = kb.nextDouble();
		
		double B = kb.nextDouble();
		
		double C = kb.nextDouble();
		
		double max=A;
	
			if (B>max) {  
				max= B;
			 if(C>max)
				max = C; }
			
		if (max<A+B && max<B+C && max<C+A )
			
			System.out.print("The perimeter is "+ (A+B+C));
			
			
		else
		
		System.out.print("Input is invalid ");
		
		
			
		
	}

}

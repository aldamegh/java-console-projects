import java.util.Scanner;
public class Divisible {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		
		
		int num = kb.nextInt();
		
		
		boolean z ;
		
		z = (num%5==0 && num%6==0);
		
		System.out.println("Is 10 divisible by 5 and 6? " +z);
		
		
		z= (num%5==0 || num%6==0);
		
		System.out.println("Is 10 divisible by 5 or 6? " +z);
		
		
		z = (num%5==0 || num%6==0);
		
		System.out.print("Is 10 divisible by 5 or 6, but not both? " +z);
		

	}

}

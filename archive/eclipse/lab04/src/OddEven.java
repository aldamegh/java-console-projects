import java.util.Scanner;
public class OddEven {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter x: " );
		int x= kb.nextInt();
		
		
		if (x%2==0) System.out.println(x+" is Even");
		
		
		else  System.out.println(x+" is Odd");
		
		

	}

}

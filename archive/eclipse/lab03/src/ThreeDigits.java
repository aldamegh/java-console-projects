import java.util.Scanner;
public class ThreeDigits {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter x : ");
		int x=kb.nextInt();
		
		int Digit1=x%10;
		x=x/10;
		int Digit2=x%10;
		x=x/10;
		int Digit3=x%10;
		
		System.out.println("First digit is "+Digit3);
		
		System.out.println("Middle Digit is "+Digit2);
		
		System.out.println("Last Digit is "+Digit1);
	}

}

import java.util.*;
public class a01 {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		int num, sum= 0;
		System.out.println("Enter an integer (input ends if it is 0)");
		num = kb.nextInt();
		if (num != 0) {
		do {
			sum+= num;
	
			num = kb.nextInt();
		}while (num != 0);
		System.out.println("The sum = " + sum);
	
		}
		else {
			System.out.println("End");
		
		}
		
	}
}

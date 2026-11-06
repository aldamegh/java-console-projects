import java.util.Scanner;
public class Digits {

	public static void main(String[] args) {
		Scanner kb = new Scanner (System.in);
		
		System.out.print("Enter a number (-1 to end): ");
		int num = kb.nextInt();
		int i = 1;
		
		while (num!=-1) {
			
			while(num !=0 ) {
			
			System.out.println(("Digit"+i +" = "+num%10) );
			num = num/10;
			
			i++;
			
		}
		
			System.out.print("Enter a number: ");
			num = kb.nextInt();
			
			
			
	}

	}
}




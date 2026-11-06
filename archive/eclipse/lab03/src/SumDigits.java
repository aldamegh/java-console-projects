import java.util.Scanner;
public class SumDigits {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter an integer between 0 and 1000: ");

		int integer = kb.nextInt();
		
		int temp =integer;
		int digits1 = temp%10;
		temp=temp/10;
		int digits2 = temp%10;
		temp=temp/10;
		int digits3 = temp%10;
		
		int sumDig=digits1+digits2+digits3;
		System.out.print("The sum of all digits in "+integer+" is "+sumDig);
	}

}

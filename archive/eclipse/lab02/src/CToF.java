import java.util.Scanner;
public class CToF {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter a temperature in Celsius: ");
		double C=kb.nextInt();
		
		double F=(C*(9/5.0)+32);
		
		System.out.print(C+"  Celsius is "+ F +" Fahrenheit");
		

	}

}

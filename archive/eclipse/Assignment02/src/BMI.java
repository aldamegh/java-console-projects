import java.util.Scanner;
public class BMI {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner (System.in);
		
		System.out.print("Enter weight in pounds: ");
		
		double pounds = kb.nextDouble();
		
		System.out.print("Enter height in inches: ");
		
		double height = kb.nextDouble();
		
		
		double kg = (pounds*0.45359237);
		
		double m = (height*0.0254);
		
		double BMI = (kg/(m*m));
		
		System.out.print("BMI is "+ BMI);
	}

}

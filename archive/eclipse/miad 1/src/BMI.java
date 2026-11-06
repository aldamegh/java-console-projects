 import java.util.Scanner;
public class BMI {

	public static void main(String[] args) {
		Scanner kb= new Scanner (System.in);
		
		System.out.print("BMI" );
		
		double BMI = kb.nextDouble();
		
		if (BMI<18.5)
			System.out.print("L");
		else if (BMI>=18.5 && BMI<25)
			System.out.print("N");
		else if (BMI<30 && BMI>=25)
			System.out.print("h");
		else if ( BMI>=30)
			System.out.print("o");
		
	}

}

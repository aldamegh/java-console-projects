import java.util.Scanner;
public class ABCDF {

	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		
		System.out.println("Please Enter your numercal grade: ");
		
		int x =kb.nextInt();
		if(x>100 || x<0)
			System.out.print("Error");
		
		else {if (x<=100 && x>=95)
			System.out.println("A+");
		else if (x<95 && x>=90)
			System.out.println("A");
		else if(x<90 && x>=85)
			System.out.println("B+");
		else if (x<85 && x>=80)
			System.out.println("B");
		else if (x<80 && x>=75)
			System.out.println("C+");
		else if (x<75 && x>=70)
			System.out.println("C");
		else if (x<70 && x>=65)
			System.out.println("D+");
		else if (x<65 && x>=60)
			System.out.println("D");
		
		else if (x>=0 && x<60)
			System.out.println("F");
		 System.out.print("Thank you for using the simple program");

	}
	}
}


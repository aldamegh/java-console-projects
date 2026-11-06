 import java.util.Scanner;
public class Grade {

	public static void main(String[] args) {
		Scanner kb= new Scanner (System.in);
		
		System.out.print("Mark: " );
		
		int mark = kb.nextInt();
		
		if (95<=mark&& mark<=100)
			System.out.print("A+");
		else if (90<=mark && mark<95)
			System.out.print("A");
		else if (85<=mark && mark<90)
			System.out.print("B+");
		else if (80<=mark && mark<85)
			System.out.print("B");
		else if (75<=mark && mark<80)
			System.out.print("C+");
		else if (70<=mark && mark<75)
			System.out.print("C");
		else if (65<=mark && mark<70)
			System.out.print("D+");
		else if (60<=mark && mark<65)
			System.out.print("D");
		else if (60>mark && mark>=0)  
			System.out.println("F");
		else 
			System.out.println("error");
		
		System.out.print("End");
		
	}
}
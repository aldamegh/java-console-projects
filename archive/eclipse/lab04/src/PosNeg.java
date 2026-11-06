import java.util.Scanner;
public class PosNeg {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter x: " );
		int x= kb.nextInt();
		
		
		if (x>0) System.out.println(x+" is positive");
		
		else if  (x==0) System.out.println(x+" is positive " + "x is zero"); 
		
		
		else  System.out.println(x+" is negative");
		
		

	}

}

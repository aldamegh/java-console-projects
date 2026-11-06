import java.util.Scanner;
public class SpeedFine {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("please enter your speed: ");
		int speed = kb.nextInt();
		
		if (speed<0 ) System.out.println("error");
		
		else if  (speed<=100) System.out.println("NO Fine ");
		
		else if (speed>100 && speed <=113)System.out.println("300");
		
		else if (speed>113 && speed <=140) System.out.println("500");
		
		else  System.out.println("1000");
		
	
		
	}

}

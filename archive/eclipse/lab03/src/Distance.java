import java.util.Scanner;
public class Distance {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter x1 and y1: ");
		double x1= kb.nextDouble();
		double y1= kb.nextDouble();
		System.out.print("Enter x2 and y2: ");
		double x2 = kb.nextDouble();
		double y2 = kb.nextDouble();
		
//		Math.pow((x2-x1), 2);
//		
//		Math.pow((y2-y1), 2);
		
		double distance = Math.pow((x1 - x2) * (x1 - x2) +
				 (y1 - y2) * (y1 - y2), 0.5);

				 System.out.println("The distance between the two pointsis " + distance);

	}

}

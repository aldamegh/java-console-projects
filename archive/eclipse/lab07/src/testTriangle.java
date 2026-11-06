import java.util.Scanner;
public class testTriangle {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		Triangle s1 = new Triangle(); 
		 
		
		Triangle.side1 = kb.nextDouble();
		Triangle.side2 = kb.nextDouble();
		Triangle.side3 = kb.nextDouble();
		
		System.out.println( s1.isItTriangle() );
		System.out.println( s1.isItRight() );
		if (s1.isItTriangle() && s1.isItRight()) {
			
			System.out.print("The area is "+s1.area());
		}
		else if (!s1.isItTriangle()) {
			System.out.print("It is not a triangle");
		}
		else if (!s1.isItRight()) {
			System.out.print("It is not a  right angle tiangle ");
		}
		
	}
	}



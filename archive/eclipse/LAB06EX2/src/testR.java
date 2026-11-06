import java.util.Scanner;

public class testR {

	public static void main(String[] args) {
		Scanner kb =new Scanner (System.in);
		
		Rectangle R = new Rectangle();
		System.out.print("Enter width and length: ");
	     R.width = kb.nextDouble();
		 R.lenght = kb.nextDouble();

		 R.displayArea();
		
		

	}

}

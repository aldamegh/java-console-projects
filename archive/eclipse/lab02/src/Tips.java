import java.util.Scanner;
public class Tips {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter subtotal and gratuity rate: ");
		
		double sub = kb.nextDouble();
		double gra = kb.nextDouble();
			gra=sub*(gra/100);
		double total = sub+gra;
		
		System.out.print("The gratuity is $"+gra +" total is $"+ total);
	}

}

import java.util.Scanner;
public class CompoundInterest {

	public static void main(String[] args) {
	Scanner kb = new Scanner(System.in);
	
	System.out.print("Enter the amount to be saved for each month: ");
	
	double saved = kb.nextDouble();
	
	System.out.print("Enter the annual interest rate: ");
	
	double interest = kb.nextInt();

	System.out.print("Enter the number of months: ");

	int months = kb.nextInt();
	
	
	interest= (interest/100)/12 ;
	
	double account= 0;
	int i=0 ;
	
	
	while(months>i) { i++ ;
	
	account=(account+saved)*(1+interest) ;
		
		
	}

	
	
	System.out.println("After the "+months+"th month, the account value is "+account);
	
	
	
	
	
	
	
	}

}

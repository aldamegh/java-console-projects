import java.util.Scanner;

public class MinsToYearsDays {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter the number of minutes: ");
		
	   int minutes = kb.nextInt();
	   
	   int years = ((minutes)/(365*24*60));
	   
	   int days = ((minutes%525600)/(24*60));

       System.out.print(minutes+ " minutes is approximately "+ years + " years and "+ days+" days" );
       
	}

}

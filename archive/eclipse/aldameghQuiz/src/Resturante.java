//
//   mohammed aldamegh   [student identifier removed]
//	 Sunday	
//
import java.util.Scanner;
public class Resturante {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		double arr[] = new double [100];
		int option;
		int size=100;
		int i=0;
		System.out.println("Enter your choise");
		do { 
		System.out.println("1) buy Sandwitvhes " +"2) print all sales"+"\n"
				+"3)Quit") ;
		 option=kb.nextInt();
		 if (option==1) {
			 
			 System.out.print(" how many shawerma chiken");
			 
			double chiken = kb.nextInt();
			 
			 System.out.print(" how many shawerma meat");
			 
			double meat = kb.nextInt();
			arr[i]= (meat*10)+(chiken*5)+(chiken*15/100)+(meat*15/100);
			System.out.println("the bill is "+ arr[i]);
			i++;
			size=i;
		 }
			if (option==2) {
				
		for ( i=0 ; i<size ; i++) {
			
			System.out.println("the sale total "+arr[i]+" SA ");
			
		}
			
				
				
			
		 }
		
			}while(option!=3);
		
		
		
		}
	}		
		
		
		
		
	

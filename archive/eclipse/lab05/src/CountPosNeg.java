import java.util.Scanner;
public class  CountPosNeg {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter integers ending with 0: ");
		
		int x = kb.nextInt();
		int countr=0;
		int positives=0;
		int negatives=0;
		double average=0;
		int sum =0 ;
		if(x!=0){
		while(x!=0) {
			
			countr++;
			if (x>0)  positives++;
			else negatives++;
			sum=sum+x;	
			x = kb.nextInt();
			
		}
		average=(double)sum/countr;
		System.out.println("The number of positives is "+positives);
		System.out.println("The number of negatives is "+negatives);
		System.out.println("The count is "+countr);
		System.out.println("The sum is "+sum);
		System.out.println("The average is "+average);
		}
		else System.out.println();
		
	}
}
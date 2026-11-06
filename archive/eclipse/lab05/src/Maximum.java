import java.util.Scanner;
public class  Maximum {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter how many numbers you have? ");
		
		int n = kb.nextInt();
		System.out.print("Enter the numbers :");
		int MaxNum=Integer.MIN_VALUE;
		int SMaxNum=Integer.MIN_VALUE;
		int SMinNum=Integer.MAX_VALUE;
		int MinNum=Integer.MAX_VALUE;
		for (int i= 0 ; i<n;i++) {
			
			int x = kb.nextInt();
			
			if (x>MaxNum) MaxNum=x;
			else if (x>SMaxNum) SMaxNum=x;
			if (x<MinNum) MinNum=x;
			else if (x<SMinNum) SMinNum=x;
			
			
		}
			
		System.out.println("The Maximum is "+MaxNum);
		System.out.println("The SMaximum is "+SMaxNum);
		
		System.out.println("The Minimum is "+MinNum);
		System.out.println("The SMinimum is "+SMinNum);
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
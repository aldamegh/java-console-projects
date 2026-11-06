// Mohammed AlDamegh
// [student identifier removed]
import java.util.Scanner;
public class Numbers {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int nums[]= new int[100];
			int size=0 ;
			System.out.print("Enter The Numbers: ");
			int x=kb.nextInt();
		for(int i =0 ; i<nums.length && x!=0;i++ ) {
			nums[i]=x;
			x=kb.nextInt();
			size++;
		}
		
		System.out.print("The numbers are: ");
		for (int i =0 ; i<size ; i++) {
		System.out.print(nums[i]+" ");
		  }
		System.out.println();
		
		int i=0;
		while(i==0) {
			System.out.print("Please enter two locations j and k: ");
			
			int j=kb.nextInt(); int k=kb.nextInt();
			
			if(k>j) {
				if(k>0 &&j>0) {
					if(k<nums.length) {
						System.out.print("The elements between " +j+ " and " +k+ " are: ");
						for( i=j; i<=k ;i++) {
							System.out.print(nums[i]+" ");
					}
					}
					else System.out.println("ERROR: j and k must be less than the number of entered numbers.");
				}
				else  System.out.println("ERROR: j and k can't be negative.");
			
			
			}
		else System.out.println("ERROR: k must be greater than j");
			
			
			}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}

}

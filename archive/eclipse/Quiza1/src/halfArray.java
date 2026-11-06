import java.util.Scanner;
public class halfArray {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int n=50;
		int size , i=0 ;
		int [] arr = new int[n];
		int x= kb.nextInt();
		double ave=0;
		while (i<n && x!=-1) {
			
			arr[i]= x ;
			x= kb.nextInt();
			i++;
			
		}
		System.out.println();

		 size = i;
		System.out.print("The number of integers that have been read is "+ size);
		
		System.out.println();
		System.out.print("ordr ");

		for ( i=0 ; i<size ; i++) System.out.print(arr[i]);
		System.out.println();

		System.out.print("revers ");

		for ( i=size-1 ; i>=0 ; i--) System.out.print( arr[i]);
		
		System.out.println();

		
		for ( i=0 ; i<size/2 ; i++) System.out.print(arr[i]);
		System.out.println();

		for ( i=0 ; i<size ; i++) ave += arr[i];
		System.out.println("ave "+ave/size);
		
		
		
		
		
		
		
		
		
		
	}

}

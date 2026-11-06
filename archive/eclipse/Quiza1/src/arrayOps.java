import java.util.Scanner;
public class arrayOps {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int max_size = 50;
		int ar[] = new int[max_size];
		
		System.out.print("Please enter the numbers: ");
		
		int x= kb.nextInt();
		
		int i =0;
		
		while (i<max_size && x!=-1) {
			ar[i]=x;
			x= kb.nextInt();
			i++;
		}
		System.out.println();
		
		System.out.println("The array is of size: "+i);
		int size=i;
		i=0;
		System.out.print("The elements of the array are: ");

		while (i<size) {
			System.out.print(ar[i]+" ");

			i++;
		}	
		
		System.out.println();

		System.out.print("Please enter the search number: ");
		x= kb.nextInt();
		i=0;
		int index=-1;
		while (i<max_size && index==-1) {
			if(ar[i]==x)index=i;
			
			i++;
		
	}
		if (index!=-1) System.out.print("The number "+ x + "is at Index "+index);
		
		else System.out.print("Sorry. Number "+ x + " is not in the Arra ");
		
		System.out.println();
		
//		int temp = ar[size-1];
//		for (i=size-1; i > 0; i--)
//		ar[i]=ar[i-1];
//		ar[0] = temp;
//	
//		System.out.print("The elements after rightShift: ");
//		for (i=0; i<size; i++) System.out.print(ar[i]+" ");
//		System.out.println();
		
		
		System.out.print("Please enter the locations to switch: ");
				i = kb.nextInt();
				int j = kb.nextInt() ;
			int	temp = ar[j] ;
				ar[j] = ar[i] ;
				ar[i] = temp ; 
			
			System.out.print("The elements of the array are: ");
i=0;
			while (i<size) {
				System.out.print(ar[i]+" ");

				i++;
			}	
			
		
		
//		int temp = ar[size-1];
//		for(i=size-1 ; i>0 ; i--) {
//			ar[i]=ar[i-1];
//			ar[0]=temp;
//		}
//		
//		System.out.print("The elements after rightShift: ");
//		
//		for(i=0 ; i<size ; i++) {
//			System.out.print(ar[i]+" ");
//		}	
	}
}

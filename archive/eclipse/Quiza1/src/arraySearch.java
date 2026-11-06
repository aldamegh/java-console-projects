import java.util.Scanner;

public class arraySearch {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int Max_size =50;
		int ar[]= new int[Max_size];
		System.out.print("Please enter the numbers: ");
		int i=0;
		int x = kb.nextInt();
		while ( x!=-1) {
			ar[i]=x;
			x = kb.nextInt();
			i++;
		}
		System.out.println();

		int size=i;
		System.out.print("Please enter the search number: ");
		x = kb.nextInt();
		int index=-1;
		 i=0;
		while (i<size && index==-1 ) {
			
			if (ar[i]==x)index=i;
			i++;
		}
		System.out.println();

		if (index!=-1) System.out.print("The number "+x+" is at Index "+index);
		
		 else System.out.println("Sorry "+x+" is not in the Array");
	}

}

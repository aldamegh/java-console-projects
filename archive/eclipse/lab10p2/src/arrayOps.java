import java.util.Scanner;
public class arrayOps {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		final int Max_size = 50;
		int ar[] = new int [Max_size];
		
		System.out.print("Please enter the numbers: ");
		
		int i =0;
		int x = kb.nextInt();
		
		while (x!=-1) {
			ar[i++] = x;
			x=kb.nextInt();
			
		}
		
		int size = i;
		System.out.println("The array is of size: "+ i);
		
		System.out.println("The elements of the array are: "+ar[size]);
		
		System.out.print("Please enter the search number: ");
		
		x=kb.nextInt();
		int index = -1;
		i=0;
		while (index == -1 && i < size ){
			if (ar[i]==x)index =i ;
			i++;
		}
		
		if (index !=-1)
		System.out.println("The number "+x+" is at "+index);
		else 
			System.out.println("Sorry. Number "+x+"is not in the Array.");
	}

}

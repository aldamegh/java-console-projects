import java.util.Scanner;
public class Day {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		int j , k , m , q  ;
		
		System.out.print("Enter year: (e.g., 2012):");
		
		 j= k = kb.nextInt();

		System.out.print("Enter month: 1-12:");
		
		 m = kb.nextInt();
		
		System.out.print("Enter the day of the month: 1-31:");
		
		q = kb.nextInt();
		
		if (m==1||m==2) {
				m+=+12;
				j+=-1;
				k+=-1;
		}
		
		j = j/100 ;
		
		k = k%100 ;
		
		int h = ( ((q)+ (26*(m+1)/10) + (k) + (k/4) + (j/4) + (5*j))%7 );
		
	   if (h==0)
		   System.out.print("Day of the week is Saturday");
	   
	   else if (h==1)
		   System.out.print("Day of the week is Sunday");
	   
	   else if (h==2)
		   System.out.print("Day of the week is Monday");
		   
	   else if (h==3)
		   System.out.print("Day of the week is Tuesday");
		   
	   else if (h==4)
		   System.out.print("Day of the week is Wednesday");
		   
	   else if (h==5)
		   System.out.print("Day of the week is Thursday");
		   
	   else if (h==6)
		   System.out.print("Day of the week is Friday");
		   
	
		
	}

}

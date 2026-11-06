// 
//Mohammed AlDamegh
// 
import java.util.Scanner;
public class Names {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please enter how many students: ");
		int n = kb.nextInt();
		String first[]= new String[n];
		String last[]= new String[n];
		
		for (int i =0 ; i<n ; i++) {
			
			first[i]= kb.next();
			last[i]= kb.next();
		}
		System.out.println("The students names are:");
		for (int i =0 ; i<n ; i++) {
			System.out.println("Student "+i+" : "+first[i]+" "+last[i]);
			}
		
		int countr = 0;
		
		for (int i =0 ; i<n ; i++) {
			
			if (first[i].equalsIgnoreCase("Mohammed")) countr++;
			}
		
		System.out.println("There are "+countr+" Students with first name  \"Mohammed\" ");
		
		int n2=n;
		for (int i =0 ; i<n ; i++) {
			if (last[i] == "removed") break;
			if ( last[i].substring(0,2).equalsIgnoreCase("AL") ) {
				for( int j=i ;j<n-1 ;j++) {
				last[j]= last[j+1] ;
				first[j]= first[j+1];
				if (j==last.length-2) last[j+1]="removed";
				
				}	n2--; i--; 	
			  }
		}
		
		System.out.println("The students with last name not beginning with \"AL\" are: ");
		
		for (int i =0 ; i<n2 ; i++) {
			System.out.println("Student "+i+" : "+first[i]+" "+last[i]);
		  }
		
		
	}

}

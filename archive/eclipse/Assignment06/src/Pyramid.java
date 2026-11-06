import java.util.Scanner;
public class Pyramid {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in) ;
		
		System.out.print("Enter the number of lines: ");
		int n = kb.nextInt ();

	int s =n;
	int st2=1;
	int a=1;
		for (int i=0 ; i<n ; i++) {
				
		for( int j =0 ; j<s;j++) {
					
		 System.out.print("  ");
		 
			}
		
	     for (int h=n ; h>1; h--){
	    	 
	    	 if (a>=h)System.out.print(h+"  ");
	    		 
	    	 }
			
		for( int g=1 ; (g<=st2) ;++g)  {
			
			if (g<st2)
			System.out.print(g+"  ");
			else if (g==st2)
				System.out.print(g);
		   	}
			
			st2+=1;
			s--;
			a++;
			System.out.println();
		
		}
	
	}

}

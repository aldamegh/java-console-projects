import java.util.Scanner;
public class Numbers {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter two integer numbers n1 , n2: ");
		int n1 = kb.nextInt();
		int n2 = kb.nextInt();

        int min=n1;
        int max=n1;
        
        int i=0;
       
       if (max<n2)
    	   max=n2;
        	
       if (min>n2)
    	   min=n2;
       
		while(max>=min) {
		
			if(!(min%5==0) || !(min%6==0)) {
			 	if(min%5==0) { i++;
				System.out.print(min+",");
				}
			else if(min%6==0) {i++;
			System.out.print(min+",");
			}
			}
			min++;
			
			if (i%10==0)
				System.out.println();
			
    	
	      	}
               }  
                   }
				
			
		
		

	


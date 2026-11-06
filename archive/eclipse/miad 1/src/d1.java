import java.util.Scanner;
public class d1 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter an integer: ");
		
		
		int num = kb.nextInt();
		
		
	
		
			if(num%5==0 && num%6==0)
		
			 	System.out.println("Is 10 divisible by 5 and 6? " +"true");
		 
		 	 if(num%5!=0 || num%6!=0)
				
			 	System.out.println("Is 10 divisible by 5 and 6? " +"fales");
				
		
		
		 	 if(num%5==0 || num%6==0)
		
		 		System.out.println("Is 10 divisible by 5 or 6? " +"true");

			
			 if(num%5!=0 && num%6!=0)
		
				System.out.println("Is 10 divisible by 5 or 6? " +"fales");
		
		
			 if (num%5==0 || num%6==0)
		
		 		System.out.print("Is 10 divisible by 5 or 6, but not both? " +"true");
		
		
		
			 if (num%5!=0 && num%6!=0)
		
				System.out.print("Is 10 divisible by 5 or 6, but not both? " +"fales");
			
		
		
		

	}

}

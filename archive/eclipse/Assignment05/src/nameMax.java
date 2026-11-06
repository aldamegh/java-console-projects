

import java.util.Scanner;
public class nameMax {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter the number of students: ");
		int i=kb.nextInt();
		
		System.out.print("Enter a student name:");
		
		String name= kb.next();
		 
		System.out.print("Enter a student score:");
		
		double score = kb.nextDouble();
		
		double max = score;
		
		String name1= name;
		i--;
		while(i>0) {;i--;
		
		System.out.print("Enter a student name:");
		
		 name= kb.next();
		 
		System.out.print("Enter a student score:");
		
		 score = kb.nextDouble();
		 
		 if(max<score) { max=score;
			 name1= name;}
	
		if(i==0)
			System.out.print("Top studen "+name1+"'s score is "+max);
			
		}
		
		

		

	}

}

import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		int i, num, j ,num2;

		 num = kb.nextInt();
		 
		 num2 = num;
		
		
		i=0;
		
		for(i=0;i<num;i++) { System.out.println("");
			
			for (j=0;j<=i;j++) {System.out.print("*");
			}
			
		}
	}

}

import java.util.Scanner;
public class Square {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter a character: ");
		
		char  chr = kb.next().charAt(0);
		
		System.out.print("Please enter a number: ");
		
		int  n = kb.nextInt();
		int i=0;
		while(n>i) {
			for( int j=0;n>j;j++)
			System.out.print(chr);
			System.out.println();
			i++;
		}
		
		
	}
}
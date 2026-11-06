import java.util.Scanner;
public class a03 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter num: ");
		int s = kb.nextInt();
		
	int x=s,t=s;

		while(s!=0) {
			
			if(x<s) {
			t=x;	
			x=s;}
			else if (t<s)
				t=s;
			else if (t==x)
				t=s;
			
			s = kb.nextInt();	
		}
	System.out.println("Largest num: "+x);
	System.out.println("Seconed largest num: "+t);
		}

	
	
	}



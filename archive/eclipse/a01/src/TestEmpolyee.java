import java.util.Scanner;
	public class TestEmpolyee {
		
		
		public static void main(String[]args) {
		Scanner kb= new Scanner(System.in);
		
		Employee s1 = new Employee();
		
		s1.FristName = kb.next();
		
		s1.LastNeme = kb.next();
		
		s1.Salary = kb.nextDouble();
		
		s1.id = kb.nextInt();
		

		System.out.println("FristNeme = " + s1.FristName);
		
		System.out.println("LastNeme = "+ s1.LastNeme);

		System.out.println("Salary = "+ s1.Salary);

		System.out.println("id = "+ s1.id);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
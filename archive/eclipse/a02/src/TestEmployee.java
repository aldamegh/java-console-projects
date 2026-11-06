 import java.util.Scanner;
public class TestEmployee {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in) ;
		
		Employee s1 = new Employee();
		
		String FristNeme = kb.next();
		
		s1.setFristNeme(FristNeme);
		
		String LastNeme = kb.next();
		
		s1.setLastNeme(LastNeme);
		
		double Salary = kb.nextDouble();
		
		s1.setSalary(Salary);
		
		int id = kb.nextInt();
			
		s1.setId(id);
		
		System.out.println("FristNeme = " + s1.getFristNeme());
		
		System.out.println("LastNeme = "+ s1.getLastNeme());

		System.out.println("Salary = "+ s1.getSalary());

		System.out.println("id = "+ s1.getId());

		
	}

}

import java.util.Scanner;
public class teststudent {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner (System.in);
		
		student s1 = new student();
		
		student s2 = new student();
		
		System.out.print("Enter course name: ");
		student.course=kb.next();
		System.out.print("Enter Name, Age and GPA of first student:");
		s1.name= kb.next();
		s1.age=kb.nextInt();
		s1.GPA=kb.nextDouble();
		System.out.print("Enter Name, Age and GPA of second student:");
		s2.name= kb.next();
		s2.age=kb.nextInt();
		s2.GPA=kb.nextDouble();
		
		System.out.println("Information of the first student: ");
		s1.printInfo();
		
		System.out.println("Information of the second student: ");
		s2.printInfo();
		
		s1.GPAToPercentage();
		s2.GPAToPercentage();
	}

}

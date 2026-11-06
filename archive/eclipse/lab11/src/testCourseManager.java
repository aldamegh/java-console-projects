import java.util.Scanner;
public class testCourseManager {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		courseManager cm = new courseManager();	
		System.out.print("Enter the number of Students :");
		int N = input.nextInt();
		for (int i=0;i<N;i++) {
			System.out.print("Please enter the ID, name, and score of student "
					+i+" : " );
			Student s = new Student(input.nextInt(),input.next(),input.nextDouble());
//			cm.addStudent(s);
				}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
	}	
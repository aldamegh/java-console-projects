import java.util.Scanner;

public class TestMyRectangle {

	public static void main(String[] args) {
		
		MyRectangle s1 = new MyRectangle();
		MyRectangle s2 = new MyRectangle();

		s1.width = 4;
		s1.height = 8;
		
		s2.width = 3.5;
		s2.height = 35.9;
		
		System.out.println("The area of a rectangle with width "+s1.width+" and height "+s1.height+" is "+(s1.width*s1.height)+"\r\n" + 
				"The perimeter of a rectangle is "+ (2*(s1.height)+2*(s1.width)) );
		System.out.println("The area of a rectangle with width "+s2.width+" and height "+s2.height+" is "+(s2.width*s2.height)+"\r\n" + 
				"The perimeter of a rectangle is "+ (2*(s2.height)+2*(s2.width)) );
		s1.printRectangle();

	}

}

//
//Scanner kb = new Scanner (System.in);
//
//student S1 = new student () ;
//student S2 = new student () ; 
//
//System.out.print("Enter Name, Age and GPA of first student:");
//
//S1.name = kb.next();
//S1.age = kb.nextInt();
//S1.GPA = kb.nextDouble();
//
//
//System.out.print("Enter Name, Age and GPA of first student:");
//
//S2.name = kb.next();
//S2.age = kb.nextInt();
//S2.GPA = kb.nextDouble();
//
//System.out.print("Information of the first student:");
//S1.printInfo();
//System.out.println("Information of the second student:");
//S2.printInfo();


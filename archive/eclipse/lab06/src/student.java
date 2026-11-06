	
public class student {
	
	public String name; 
     
	public int age ;
	
	public double GPA;
	
	public static  String course;
	
	public void GPAToPercentage() {
		System.out.println("Student "+name+" GPA: "+GPA);
		System.out.println("Student "+name+" GPA as a Percentage: %"+(GPA*20));
	}
	public void printInfo() {
		
		System.out.println("------------------------------");
		System.out.println("Student name: "+name);
		System.out.println("Student age: "+age);
		System.out.println("Student GPA: "+GPA);
		System.out.println("------------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}



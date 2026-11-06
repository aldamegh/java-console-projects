

	
	class Student{ 
		public String name; 
		public Student (String n) {name = n;} 
	}
public class a05 {

	public static void changeName (Student s) {
	s = new Student ("Fahad");
	s.name = "Sultan";  
	s.name = "Saad"; 
	System.out.print (s.name);  }

	

public static void main (String [] args) {
	
	Student Student = new Student ("Saud");
	changeName (Student)
	;  System.out.print (Student.name);


}

}


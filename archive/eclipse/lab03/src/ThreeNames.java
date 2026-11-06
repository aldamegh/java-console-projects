import java.util.Scanner;
public class ThreeNames {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
	System.out.print("Please Enter The First name: ");
	String  FirstName = kb.next();
	
	System.out.print("Please Enter The Middle name: ");
	String  MiddleName = kb.next();
	
	System.out.print("Please Enter The Last name: ");
	String  LastName = kb.next();
	
	LastName= "AL"+LastName;
	
	String  FullName = FirstName + " "  + MiddleName +" " + LastName ;
	
	System.out.print("The Full Name: "+FullName);
	}

}

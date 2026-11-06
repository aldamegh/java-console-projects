import java.util.Scanner;
public class TestBook {

	public static void main(String[] args) {
		Scanner kb = new Scanner (System.in);
		
		Book s1 = new Book();
		
		System.out.println("Please, enter the book details #ISBN,author, title, and genre." );
						
		s1.ISBN = kb.nextInt(); 
		
		s1.author = kb.next();
		
		s1.title = kb.next();
		
		s1.genre = kb.next();
		
		
	if(s1.verifyISBN(s1.ISBN)==false)
		System.out.print("Invalid ISBN");
	
	else {
	System.out.println(s1.toString());
	System.out.print("The book reference is:" +
			s1.generateReference());
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

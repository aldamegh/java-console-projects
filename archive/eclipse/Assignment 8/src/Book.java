
public class Book {

	public int ISBN;
	
	public String author;
	
	public String title;
	
	public String genre;

	public Book() {	
	}

	
	public String generateReference()
	{
	return String.valueOf(author.charAt(0)) +
	String.valueOf(author.charAt(1)) + "-"
	+ String.valueOf(genre.charAt(0)) +
	String.valueOf(genre.charAt(1));
	}

		
	public boolean verifyISBN( int ISBN) {
		
		int n4=ISBN%10;
		ISBN=ISBN/10;
		
		int n3=ISBN%10;
		ISBN=ISBN/10;
		
		int n2=ISBN%10;
		ISBN=ISBN/10;
		
		int n1=ISBN%10;
		ISBN=ISBN/10;
		
	int t =((n1*3+n2*2+n3*1)%4);
	if (t==n4)
	return true;
	
	else  
		return false ;
	
	}
	
	
	public String toString()
	{
	return "Title:" + title + "\n" + "Author:" + author + "\n"
	+ "ISBN: " + ISBN + " - Reference Code :"
	+ generateReference() + "\n" + "Genre:" + genre;
	}
}

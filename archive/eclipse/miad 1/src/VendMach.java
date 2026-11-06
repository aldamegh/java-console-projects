import java.util.Scanner;
public class VendMach {
	public static void main(String[]args) {
		
	Scanner kb = new Scanner (System.in);
	
	System.out.print("Enter the halalas between 1 and 99 : ");
	
	int quarters , qirshs , halfs , halalas, oriamount;
	
	int amount = oriamount =kb.nextInt();
	
	
	halfs = amount/50;
	
	amount = amount%50;

	quarters = amount/25; 
	
	amount = amount%25;
	
    qirshs = amount/10;
    
    amount= amount%10;
		
    halalas = amount/1;
    
	System.out.println("halfs: "+halfs);
	
	System.out.println("quarters: "+quarters);

	
	System.out.println("qirshs: "+qirshs);
 
	System.out.println("halalas"+ halalas);
	
	System.out.print("the all of halals: "+oriamount);
	
	
	

	
		
		
		
		
		
	}

}

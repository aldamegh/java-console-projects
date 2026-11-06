import java.util.Scanner;
public class FiveDigits {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please Enter X: ");
        int x = kb.nextInt() ;
        
      System.out.println("First digit is "+ x/10000);
      
      System.out.println("Middle digit is "+ x/100%10);
      
      System.out.println("Last digit is "+ x%10);
      
      //SwitchDigits
      int temp=x;
     int Digit5 = temp%10;
     temp=temp/10;
     int Digit4 = temp%10;
     temp=temp/10;
     int Digit3 = temp%10;
     temp=temp/10;
     int Digit2 = temp%10;
     temp=temp/10;
     int Digit1 = temp%10;
        
      temp= Digit2;
     
     Digit2 =Digit4;
     
     Digit4 = temp;
     
     //ReverseDigits
      System.out.println("The changed number is "+Digit1+""+Digit2+""+Digit3+""+Digit4+""+Digit5);
      temp= Digit4;
      
      Digit4 =Digit2;
      
      Digit2 = temp;
      System.out.println("The reverse number is "+Digit5+""+Digit4+""+Digit3+""+Digit2+""+Digit1);

	}

}

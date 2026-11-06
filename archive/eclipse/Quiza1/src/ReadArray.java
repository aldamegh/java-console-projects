import java.util.Scanner;

public class ReadArray {

	public static void main(String[] args) {
			Scanner kb = new Scanner(System.in);
		
//		System.out.print("Please enter how many numbers: ");
		


double num[]= { 1.2 , 2.4 , 0.0 , 3.2 , 7.8 , 6.5 , 5.8 , 4.0 , 5.5 , 3.4 , 3.6 , 1.5 };

		double ave [] =new double[4];  
		
		for(int i =0 ; i<ave.length ; i++) {

				ave[i]=((num[i*3] + num[(i*3)+1]+ num[(i*3)+2])/3);	
		
		System.out.println("the ave of "+ ave[i]);
		}
		
		
//		System.out.print("Please enter the numbers: ");
//		
//		for(int i=0 ; i<n; i++) {
//			 num[i] = kb.nextInt();
//			 
//			 sum += num[i];
//		}
//		
//		double avr = sum/n;
//		
//		for (int i=0 ; i<n ; i++) {
//			
//			if(num[i]>avr && i != n-1 ) {
//				System.out.print(num[i]+" , ");
//				
//				j++;
//			}
//				else if(num[i]>avr && i== n-1) {
//					
//					System.out.println(num[i]);
//					j++;
//					System.out.println("the number of num is " + j );
//				}
//		}
//					int minNum =Integer.MAX_VALUE;
//					j=0;
//					for(int i=0 ; i<n ; i++) {
//						
//						if (minNum>num[i]) {
//							
//							minNum = num[i];
//							j=i;
//						}
//					}
//						int temp= num[0];
//						
//						num[0] = minNum;
//				
//						num[j] = temp ;
//					
//					
//					for(int i =0 ; i<num.length ; i++) {
//						
//						System.out.print( num[i]+" ");
//					}
//				
					
//					int secndminNum=Integer.MAX_VALUE;
//		for (int i=0 ; i<n ; i++) {
//			
//			if (secndminNum > num[i] && num[i] != num[j] ) {
//				
//				 secndminNum = num[i];
//				
//				j=i;
//			}
//		}
//		
//		System.out.println("the secndminNum is "+ secndminNum);
//		
//		System.out.println("the index of secndminNum is "+ j);
//	
					
	}
}
//		
//		System.out.print("The numbers in order: ");
//		
//		
//		for(int i=0 ; i<n; i++) {
//			System.out.print(num[i]+" ");
//		}
//		
//		System.out.println();
//		
//		System.out.print("The numbers in reverse: ");
//
//		
//		for(int i=0 ; i<n; i++) {
//			System.out.print(num[n-i-1]+" ");
//		}
//		System.out.println();
//
//		System.out.print("The odd numbers only: ");
//
//		for(int i=0 ; i<n; i++) {
//			if (num[i]%2!=0) {
//				System.out.print(num[i]+" ");
//			}
//		}
//		
//		System.out.println();
//
//		System.out.print("The even numbers only: ");
//
//
//		for(int i=0 ; i<n; i++) {
//			if (num[i]%2==0) {
//				System.out.print(num[i]+" ");
//			}
//		}
//		
//		
//		
//		
//		
//		
//		}
//		}
//	
//

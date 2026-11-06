
public class Triangle {
		
	
		public static double side1 ;
		
		public static double side2 ;
		
		public static double side3 ;
		
		
		
		
				public boolean isItTriangle() {
					
					if (side1+side2>side3 && side3+side1>side2 && side3+side2>side1) {
					
					
					return true;
					
				}
					else return false;
				}
				
				public boolean isItRight() {
					
					if (side1*side1 == side2*side2 +side3*side3
					|| side2*side2==side1*side1+side3*side3
					|| side3*side3==side2*side2+side1*side1)
					 return true;
					else return false;
					
				}
				
				public double area() {
					
						double area=-1;
					if (side1*side1 == side2*side2 +side3*side3) area=side2*side3*0.5;
					else if ( side2*side2==side1*side1+side3*side3)area=side3*side1*0.5;
					else if (side3*side3==side2*side2+side1*side1) area=side2*side1*0.5;
					
					return area;
				}
				public static boolean isItRight2() {
					
					if (side1*side1 == side2*side2 +side3*side3
					|| side2*side2==side1*side1+side3*side3
					|| side3*side3==side2*side2+side1*side1)
					 return true;
					else return false;
					
				}
	 }








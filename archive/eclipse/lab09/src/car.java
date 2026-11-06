
public class car {
	
	private String model;
	
	private int  year ;

	private int mileage;
	
	private double soom;
	
	private double hadd;


    public car() { }

    public car(int year, int mileage, double soom,
    		double hadd) {
    	
    	this.year=year;
    	this.mileage=mileage;
    	this.soom=soom;
    	this.hadd=hadd;
    	
    }

   public void setModel(String model) {
	   
	   this.model=model;
   }


   public String getModel() {
	   
	   return model;
   }

   public void setYear(int year){
	   this.year=year;
   }
   
   public int getYear() {
	   
	   return year;
   }
   
   
   public void setMileage(int mileage) {
	   
	  this.mileage=mileage;
   }
   
   
   
   public int getMileage() {
	   return mileage;
   }
   
   
   public void setSoom(double soom) {
	   this.soom=soom;
   }
   
   
   public double getSoom() {
	   return soom;
   }
   
   public void setHadd(double hadd) {
	   this.hadd=hadd;
   }

public double getHadd() {
	return hadd;
}


 

   public boolean difference() {
		if (soom-hadd>0) return true;
		else   { 
			System.out.print("the soom must be leas then hadd ");
			return false;
		}
		
   }
		
		public void printCar() {
			
			
		}


















}
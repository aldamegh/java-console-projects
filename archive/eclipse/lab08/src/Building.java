
public class Building {
	
	private int apts;
	private int normal;
	private int delux;
	private double rent;
	
	public Building() {	
	}
	
	public Building(int apts, double rent) {
		this.apts = apts;
		this.rent =rent;
		
		
	}
	
	public void setApts(int apts) {
		
	
		this.apts = apts ;
	}
	
		public int getApts() {
			return this.apts;
		}
	
		public void setRent(double rent) {
			this.rent = rent ;
		
	}
		public double getRent() {
			return this.rent;
		}
		
		public int getNormal() {
			return this.normal;
		}
		
		public int getDelux() {
			return this.delux;
		}
	
		public int howManyRented() {
			return normal + delux ;
		}
		public boolean rentApt(int n, String type) {
			if (n+normal+delux>apts) return false;
			else {
				if (type.equalsIgnoreCase("normal")) normal = normal + n;
				else if (type.equalsIgnoreCase("delux")) delux = delux + n;
			
			return true;
			}	
		}
		public void printInfo() {
			System.out.println("================== Building Info ==========================");
			System.out.println("The Building has 50 appartment.");
			System.out.println("Only 35 have been rented. ");
			System.out.println("15 normal appartments with rent = 2000.0 SR per month.");
			System.out.println("And 20 delux appartments with rent 2400.0 SR per month.");
			System.out.println("===========================================================");

		}
	
	
}


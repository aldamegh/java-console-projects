
// Mohammed AlDamegh
// [student identifier removed]
public class Employees {

		private int ids[]= new int[50];
	
		private String names[]= new String[50];
	
		private int years[]= new int[50]; 
	
		private double salaries[]= new double[50];
	
		private String departments[]= new String[50];
	
		private int nEmployees;
	
			
		

	public  Employees() {}
		
	
		public int getNEmployees() {
			return nEmployees;
			}
		
		
		public int addEmployee(int id , String name , int years, double salary , String department  ) {
			
			if (nEmployees<50) {
				if (findEmploye(id)==-1) {
					ids[nEmployees] = id;
					names[nEmployees] = name;
					this.years[nEmployees] = years;
					salaries[nEmployees]=salary;
					departments[nEmployees]=department;
					
					nEmployees++;
					
					return 1;
				}
					
				return -1;
			}
			
			return -2;
		}
		
		
		public int  findEmploye(int id) {
			for(int i=0 ; i<nEmployees ; i++)
				if (ids[i]==id)
					return i;
			return -1;
		}

		public int findHighestSalary(String department) {
			int	index = -1 ;
			
			for( int i=0 ; i<nEmployees ; i++) {
				if (departments[i].equalsIgnoreCase(department)) {
					double highestsal = -1; 
					if (highestsal<salaries[i])
						highestsal=salaries[i];
					index = i;
				}
				
				}
		
			if (index != -1) {return index;} 
			return -1;
		}

		public void printEmployee(int i) {
		
			if (i<50 && i>=0) {
				System.out.println("ID: "+ids[i]+". "+"Name: "+names[i]+". "+"Years: "+years[i]+". "+
					"Salary: "+ salaries[i]+". "+ "Department: "+departments[i] );
			}
		
			else System.out.println("Error cannot print");
		}
		
		public void printAll() {
			
			if (nEmployees>0) {
			for(int i=0 ; i<nEmployees ; i++) {
				System.out.println("ID: "+ids[i]+". "+"Name: "+names[i]+". "+"Years: "+years[i]+". "+
						"Salary: "+ salaries[i]+". "+ "Department: "+departments[i] );
			}
			
		}
			else System.out.println("The list is empty!");
		}
		
		public double calculateBonus(int i) {
			double Bonus = 0;
			if (findEmploye(ids[i])!=-1) {
				
				
				if (years[i]<5) Bonus=salaries[i]*2;
				
				else if (years[i]>=5 && years[i]<=10) Bonus=salaries[i]*3;
				
				else if (years[i]>10) Bonus=salaries[i]*4;
				return Bonus;
		}
			else System.out.println("ID is not correct!");
			return -1;
		}

}
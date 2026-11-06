// Mohammed AlDamegh

import java.util.Scanner;
public class Company {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		Employees c = new Employees() ;
		System.out.println("*************************\n" +
						   "Please choose:\n" +
						   "1-Add employee\n" +
						   "2-Print employee\n" +
						   "3-Print all employees\n" +
						   "4-calculate the bonus\n" +
						   "5-Find highest salary\n" +
						   "6-Exit\n" +
						   "*************************");

		System.out.print("Enter your choice:");
		int option=kb.nextInt() ;

			while(option!=6) {

					if(option==1) {
						System.out.println("Enter ID, Name, Years, Salary, Department:");
						int x;
						x= c.addEmployee(kb.nextInt(), kb.next(), kb.nextInt(), kb.nextDouble(), kb.next()) ;
						if(x == 1)System.out.println("Added");
						else if (x == -1)System.out.println("Cannot add! ID is already used!");

						else if (x == -2)System.out.println("Cannot add! array is full!");
                        else System.out.println("Invalid employee details.");
				}
				else if(option==2) {
					System.out.print("Enter the ID of the employee ");
					int id = kb.nextInt();
					int i=c.findEmploye(id);
					c.printEmployee(i);
				}
				else if(option==3) {
					c.printAll();
				}
				else if(option==4) {
					System.out.print("Enter the ID of the employee ");
					int id = kb.nextInt();
					int i=c.findEmploye(id);
					if (i!=-1) {
						System.out.print("Employee: ");
						c.printEmployee(i);
					System.out.println("Bonus: "+c.calculateBonus(i));
						}
					else System.out.println("ID is not correct!");
					}

				else if(option==5) {
					System.out.print("Enter the department: ");
					String department = kb.next();
					int index=c.findHighestSalary(department);
					if (index==-1)System.out.println("The department is not found!");
					else {System.out.print("The employee with highest salary in " + department + " is: ");
						c.printEmployee(index);
						}
				}

				else System.out.println("incorrect input please try again!");
					System.out.println("*************************\n" +
							   "Please choose:\n" +
							   "1-Add employee\n" +
							   "2-Print employee\n" +
							   "3-Print all employees\n" +
							   "4-calculate the bonus\n" +
							   "5-Find highest salary\n" +
							   "6-Exit\n" +
							   "*************************");

			System.out.print("Enter your choice:");
			 option=kb.nextInt() ;

				}

			System.out.print("Thanks goodbye!");


	}
}

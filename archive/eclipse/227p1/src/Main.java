import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.util.regex.*;
public class Main {
	
	// in this program, it is assumed that the maximum allowed memory size is 4096 MB
	
	
    static ArrayList<Process> JobQueue = new ArrayList<Process>(30);
    static ArrayList<Process> RunningQueue = new ArrayList<Process>(30);
	static ArrayList<Process> ReadyQueue = new ArrayList<Process>(30);
	static double AllowedMemory = 4096; // in megabytes
	static int numOfProcesses = 0;
	
	public static void main(String[] args) {
		
		
		while(true) {
			
			
			Scanner pathReader = new Scanner(System.in);
			
			
			try {
				
				// Remove enclosing quotes from enclosed filepaths if they exist, and make sure that filepaths are entirely in ASCII alphabet
				
				System.out.print("Enter the path of the file for jobs to be scheduled: ");
				
				
				String path = pathReader.next();
				
				
				Pattern p = Pattern.compile("[a-zA-Z]:(" + File.separator + ".+)*" + File.separator + ".+\u2022txt");
				
				
				if(!p.matcher(path).matches()) {
					
					
					if(!path.contains(":")) {
						
						System.out.print("It seems that you did not include a colon after the volume. Continue? Yes to continue | Any other string to exit: ");
						
						String Continue = pathReader.next();
						
						System.out.println(Continue);
						
						if(Continue.equalsIgnoreCase("Yes") || Continue.equalsIgnoreCase("y"))
							
							continue;
						
						else { 
							
							System.out.print("This executable has exited.");
							pathReader.close(); 
							break; 
							
							}
						
						
						}
					
					else if(!path.contains("\\")) {
						System.out.print("It seems that the filepath does not contain a backslash (\\). Continue? Yes to continue | Any other string to exit: ");
						
						String Continue = pathReader.next();
						
                        if(Continue.equalsIgnoreCase("yes") || Continue.equalsIgnoreCase("y"))
							
							continue;
						
						else {
							
							
							System.out.print("This executable has exited.");
							pathReader.close();
							break;
							
							
						}
					}
					
					else if(!path.contains(".txt")) {
						
						
						System.out.print("It seems that the file is not a .txt file. Continue? Yes to continue | Any other string to exit: ");
						
						
						String Continue = pathReader.next();
						
						
						if(Continue.equalsIgnoreCase("yes") || Continue.equalsIgnoreCase("y"))
							
							continue;
						
						else {
							
							
							System.out.print("This executable has exited.");
							pathReader.close();
							break;
							
							
						}
					}
				
				}
				
				
				
				
				Scanner jobReader = new Scanner(new File(path));
				
				System.out.print("Use the following letters to launch the following CPU scheduling algorithms: F for FCFS | R for round robin with quantum of 10 ms | or S for SJF: ");
				String algorithm = pathReader.next();
				if(!algorithm.matches("(?i)F|R|S")) { 
					System.out.print("You entered the wrong letter for scheduling algorithms. Continue? Press Yes to continue | Any other string to exit: "); 
					String Continue = pathReader.next();
					
					if(Continue.equalsIgnoreCase("yes") || Continue.equalsIgnoreCase("y")) continue;
					
					else {
						
						System.out.println("This executable has exited.");
						pathReader.close();
						jobReader.close();
						break;
						
					}
				}
				
				
				pathReader.close();
				
				
				JobsFileReader jobs = new JobsFileReader(path, jobReader);
					
				
				jobs.start();
				
				
				
				JobsLoader loader = new JobsLoader();
				
				
				
				loader.start();
				
				
				ReadyQueueScheduler Scheduler = new ReadyQueueScheduler(algorithm);
				
				
				
				Scheduler.start();
				
				
				
				break;
				
				
			} catch(FileNotFoundException e) {
				
				System.out.print("The file whose path you entered probably does not exist. Continue? Yes to continue | Any other string to exit: ");
				
				
				String Continue = pathReader.next();
				
				
				if(Continue.equalsIgnoreCase("yes") || Continue.equalsIgnoreCase("y")) { continue; }
				
				
				else { System.out.print("This executable has exited."); pathReader.close(); break; }
				
				
			}
		}
	}
}

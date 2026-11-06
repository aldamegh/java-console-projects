import java.lang.StringBuffer;
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
	static double AllowedMemory = 1024; // in megabytes
	static int numOfProcesses = 0;
	
	public static void main(String[] args) {
		
		
		while(true) {
			
			
			Scanner pathReader = new Scanner(System.in);
			
			
			try {
				
				// Remove enclosing quotes from enclosed filepaths if they exist, and make sure that filepaths are entirely in ASCII alphabet
				
				System.out.print("Enter the path of the file for jobs to be scheduled: ");
				
				String readPath = pathReader.next();
				
				StringBuffer path = new StringBuffer(1000);
				
				Pattern p = Pattern.compile("(\"?|\'?)[a-zA-Z]:(" + File.separator + ".+)*" + File.separator + ".+\u2022txt(\"?|\'?)");
				
				
				for(String s : readPath.split("(\"|\')"))
					path.append(s);
				
				
				if(!p.matcher(path).matches()) {
					
					if(!readPath.contains(":")) {
						
						System.out.print("It seems that the filepath does not include a colon after the drive volume. Continue? Yes to continue | Any other string to exit: ");
						
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
					
					else if(!readPath.contains("\\")) {
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
					
					else if(!readPath.contains(".txt")) {
						
						
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
				
				
				
				
				Scanner jobReader = new Scanner(new File(path.toString()));
				
				
				String algorithm;
				
				System.out.print("Use the following letters to launch the following CPU scheduling algorithms: F for FCFS | R for round robin with quantum of 10 ms | or S for SJF: ");
				algorithm = pathReader.next();
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
				
				
				
				
				if(algorithm.equalsIgnoreCase("f")) Main.FCFS();
				else if(algorithm.equalsIgnoreCase("s")) Main.SJF();
				else Main.RR();
				
				
				
				break;
				
				
			} catch(FileNotFoundException e) {
				
				System.out.print("The file whose path you entered probably does not exist. Continue? Yes to continue | Any other string to exit: ");
				
				
				String Continue = pathReader.next();
				
				
				if(Continue.equalsIgnoreCase("yes") || Continue.equalsIgnoreCase("y")) { continue; }
				
				
				else { System.out.print("This executable has exited."); pathReader.close(); break; }
				
				
			}
		}
	}

	public static void RR() {
		
		int hh=1;	
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		
		System.out.println("Start RR ");
		int quantum = 10;
		long currentTime = 0;
		long totalTurnaround = 0;
		long totalWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");

		while(!Main.ReadyQueue.isEmpty()) {
			Process p = Main.ReadyQueue.remove(0);

			
			long burstTime = p.getBurst();
			if (burstTime > quantum) {
				  burstTime = quantum;
				  p.setBurst(p.getBurst()-quantum);
				  Main.ReadyQueue.add(p);
			
			}
			
			else {
				
				p.setBurst(p.getBurst()-burstTime);
				Main.ReadyQueue.remove(p);
				
			}
			
			

			
			long Turnaround = currentTime + burstTime;
			long Waiting    = currentTime-quantum;
			
			
			
			 currentTime +=burstTime;	
			 
			 
			if(p.getBurst()<=0) {
		
			System.out.println("-\t" + p.getID() + "\t" + (Turnaround) + " ms\t" + Waiting + " ms" );
			
			 totalTurnaround += Turnaround;
			 totalWaiting += Waiting;
		}
		}
		System.out.println("  Average turnaround time is " + ((double) totalTurnaround / Main.numOfProcesses) + " milliseconds.");
		System.out.println("  Average waiting time is " + ((double) totalWaiting / Main.numOfProcesses) + " milliseconds.");
	
		
	}
	
	
	
	
	
	public static void FCFS() {

	
		int hh=1;	
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		
			
			
			System.out.println(" Start FCFS");
			
			 boolean k = true;
			while(k) {
				
				if(Process.Pkey>=2) k = false;
			
		
			}
			
		long  currentTime = 0;
		long totalTurnaround = 0;
		long totalWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
		
		
		while(!Main.ReadyQueue.isEmpty()) {
			
			Process p = Main.ReadyQueue.remove(0);
			

			long Turnaround = currentTime + p.getBurst() ;
			long Waiting = currentTime ;
			currentTime =Turnaround;
			totalTurnaround +=Turnaround;
			totalWaiting    +=Waiting;
			
			
			System.out.println("-\t" + p.getID() + "\t" + (Turnaround) + " ms\t" + (Waiting) + " ms");
		}

		
		System.out.println("  Average turnaround time is " + ( (double) totalTurnaround / Main.numOfProcesses) + " milliseconds.");
		System.out.println("  Average waiting time is " + ( (double) totalWaiting / Main.numOfProcesses ) + " milliseconds.");
	}
	
	
	
	
	private static void boolen() {
		// TODO Auto-generated method stub
		
	}

	public static void SJF() {
		int hh=1;	
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		hh=1;
		while(hh<2000000) {
			hh += 1;
		}
		
		System.out.println("SJF Start");
		long  currentTime = 0;
		long totalTurnaround = 0;
		long totalWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
	
		while(!Main.ReadyQueue.isEmpty()) {
			
			Process p = Main.ReadyQueue.get(0);
			
			long minBurstTime = Integer.MAX_VALUE;
			Process minp = null;
			
			
			
			for (Process wp : Main.ReadyQueue) {
				
				if(wp.getBurst() < minBurstTime) {
					
					minBurstTime = wp.getBurst();
					minp = wp;
				}	
			}
			
			Main.ReadyQueue.remove(minp);
			
			
			
			long Turnaround = currentTime + minp.getBurst() ;
			long Waiting = currentTime;
			totalTurnaround +=Turnaround;
			totalWaiting    += Waiting;
			currentTime+= minp.getBurst() ;
			
			System.out.println("-\t" + minp.getID() + "\t" + Turnaround + " ms\t" + Waiting + " ms");
			
		}
		System.out.println("  Average turnaround time is " + ((double) totalTurnaround / Main.numOfProcesses) + " milliseconds.");
		System.out.println("  Average waiting time is " + ((double) totalWaiting / Main.numOfProcesses) + " milliseconds.");
		
	}
}

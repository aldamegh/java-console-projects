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
				
				
				JobsFileReader jobs = new JobsFileReader();
					
				
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
		int quantum = 10;
		long avgTurnaround = 0;
		long avgWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
		long eb; // for the executed burst time until now.
		while(!Main.ReadyQueue.isEmpty()) {
			Process p = Main.ReadyQueue.remove(0);
			long initialBurst = p.getBurst();
			eb = 0;
			long burstTime = p.getBurst();
			if (burstTime > quantum) {
				  burstTime = quantum;
				  p.setBurst(p.getBurst()-quantum);
				  Main.ReadyQueue.add(p);
			}
			
			
			eb = System.currentTimeMillis() - p.getArrival();
			for(Process wp : Main.ReadyQueue)
				wp.setWait(wp.getWait() + eb);
		
			p.setTermination(p.getArrival() + initialBurst + p.getWait());
			System.out.println("-\t" + p.getID() + "\t" + (p.getTermination() - p.getArrival()) + " ms\t" + p.getWait()+ " ms");
			avgTurnaround += p.getTermination() - p.getArrival();
			avgWaiting += p.getWait();
		}
		System.out.println("  Average turnaround time is " + ((double) avgTurnaround / Main.numOfProcesses) + " milliseconds.");
		System.out.println("  Average waiting time is " + ((double) avgWaiting / Main.numOfProcesses) + " milliseconds.");
	
		
	}
	
	
	
	
	
	public static void FCFS() {
		long avgTurnaround = 0;
		long avgWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
		long eb; // for the executed burst time until now.
		while(!Main.ReadyQueue.isEmpty()) {
			Process p = Main.ReadyQueue.remove(0);
			eb = 0;
			p.setState(Process.State.RUNNING);
			while(p.getState() == Process.State.RUNNING) {
				if(eb >= p.getBurst()) {
					p.setState(Process.State.TERMINATED);
					break;
				}
				eb = System.currentTimeMillis() - p.getArrival();
				for(Process wp : Main.ReadyQueue)
					wp.setWait(wp.getWait() + eb);
			}
			p.setTermination(p.getArrival() + p.getBurst() + p.getWait());
			System.out.println("-\t" + p.getID() + "\t" + (p.getTermination() - p.getArrival()) + " ms\t" + p.getWait() + " ms");
			avgTurnaround += p.getTermination() - p.getArrival();
			avgWaiting += p.getWait();
		}
		System.out.println("  Average turnaround time is " + ((double) avgTurnaround / Main.numOfProcesses) + " milliseconds.");
		System.out.println("  Average waiting time is " + ((double) avgWaiting / Main.numOfProcesses) + " milliseconds.");
		
	}
	
	
	
	
	public static void SJF() {
		long avgTurnaround = 0;
		long avgWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
		long eb; // for the executed burst time until now.
		while(!Main.ReadyQueue.isEmpty()) {
			int i = 0;
			Process p = Main.JobQueue.get(0);
			eb = 0;
			long minBurstTime = Integer.MAX_VALUE;
			for (Process wp : Main.ReadyQueue) {
				if(wp.getBurst() < minBurstTime) {
					i = Main.JobQueue.indexOf(wp);
					minBurstTime = wp.getBurst();
					p = wp;
				}	
			}
			Main.ReadyQueue.remove(i);	
			eb = 0;
			p.setState(Process.State.RUNNING);
			while(p.getState() == Process.State.RUNNING) {
				if(eb >= p.getBurst()) {
					p.setState(Process.State.TERMINATED);
					break;
			}
			eb = System.currentTimeMillis() - p.getArrival();
			for(Process wp : Main.ReadyQueue)
				wp.setWait(wp.getWait() + eb);
		}
			p.setTermination(p.getArrival() + p.getBurst() + p.getWait());
			System.out.println("-\t" + p.getID() + "\t" + (p.getTermination() - p.getArrival()) + " ms\t" + p.getWait() + " ms");
			avgTurnaround += p.getTermination() - p.getArrival();
			avgWaiting += p.getWait();
		}
		System.out.println("  Average turnaround time is " + ((double) avgTurnaround / Main.numOfProcesses) + " milliseconds.");
		System.out.println("  Average waiting time is " + ((double) avgWaiting / Main.numOfProcesses) + " milliseconds.");
		
	}
}

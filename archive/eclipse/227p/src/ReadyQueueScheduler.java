import java.util.ArrayList;
import java.lang.Math;
public class ReadyQueueScheduler extends Thread {
    public String SchAlg;
	public ReadyQueueScheduler(String alg) {
		super();
		SchAlg = alg;
	}
	
	public void run() {
		try {
			Main.ReadyQueue.wait();
			if(SchAlg.equalsIgnoreCase("f")) FCFS();
			else if(SchAlg.equalsIgnoreCase("s")) SJF();
			else if(SchAlg.equalsIgnoreCase("r")) RR();
		} catch(InterruptedException Interrupt) {
			Interrupt.printStackTrace();
		}
	}
    
	
	private void RR() {
		int quantum = 10;
		int i = 0;
		double avgTurnaround = 0;
		double avgWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
		long eb; // for the executed burst time until now.
		while(!Main.ReadyQueue.isEmpty()) {
			Process p = Main.ReadyQueue.remove(i);
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
		
		p.setTermination(p.getArrival() + p.getBurst() + p.getWait());
		System.out.println("-\t" + p.getID() + "\t" + (p.getTermination() - p.getArrival()) + "\t" + p.getWait());
		avgTurnaround += p.getTermination() - p.getArrival();
		avgWaiting += p.getWait();
		i++;
	}
	System.out.println("  Average turnaround time is " + (avgTurnaround / Main.numOfProcesses) + " milliseconds.");
	System.out.println("  Average waiting time is " + (avgWaiting / Main.numOfProcesses) + " milliseconds.");
	
		
	}
	
	
	
	
	
	private void FCFS() {
		int i = 0;
		double avgTurnaround = 0;
		double avgWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
		long eb; // for the executed burst time until now.
		while(!Main.ReadyQueue.isEmpty()) {
			Process p = Main.ReadyQueue.remove(i);
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
			System.out.println("-\t" + p.getID() + "\t" + (p.getTermination() - p.getArrival()) + "\t" + p.getWait());
			avgTurnaround += p.getTermination() - p.getArrival();
			avgWaiting += p.getWait();
			i++;
		}
		System.out.println("  Average turnaround time is " + (avgTurnaround / Main.numOfProcesses) + " milliseconds.");
		System.out.println("  Average waiting time is " + (avgWaiting / Main.numOfProcesses) + " milliseconds.");
		
	}
	
	private void SJF() {
		
		int i = 0;
		double avgTurnaround = 0;
		double avgWaiting = 0;
		System.out.println("--------------------------------------------------");
		System.out.println("-\tProcess ID\tTurnaroundTime\tWaiting time");
		System.out.println("--------------------------------------------------");
		long eb; // for the executed burst time until now.
		while(!Main.ReadyQueue.isEmpty()) {
			Process p = Main.ReadyQueue.remove(i);
			eb = 0;
			p.setState(Process.State.RUNNING);
			
			long minBurstTime = Integer.MAX_VALUE;
			
			Process minProcess = null;
			
			for (Process wp : Main.ReadyQueue) {
				
				if(wp.getBurst() < minBurstTime) {
					minBurstTime = wp.getBurst();
					minProcess = wp ;
				}	
			}
		
		Main.ReadyQueue.remove(minProcess);	
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
		System.out.println("-\t" + p.getID() + "\t" + (p.getTermination() - p.getArrival()) + "\t" + p.getWait());
		avgTurnaround += p.getTermination() - p.getArrival();
		avgWaiting += p.getWait();
		i++;	
		}
		
	}
}

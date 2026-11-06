import java.io.*;
import java.util.*;
		
		public class CPUScheduler {
		 public static void main(String[] args) {
		 // Job queue
		 Queue<PCB> jobQueue = new LinkedList<>();
		
		 // Ready queue
		 Queue<PCB> readyQueue = new LinkedList<>();
		
		 // Available memory
		 int availableMemory = 1024;
		
		 // Thread for reading from file
		 Thread fileThread = new Thread(() -> {
		 try {
		 BufferedReader br = new BufferedReader(new FileReader("job.txt"));
		 String line;
		 while ((line = br.readLine()) != null) {
		 String[] parts = line.split(":");
		 int id = Integer.parseInt(parts[0]);
		 String[] parts2 = parts[1].split(";");
		 int burstTime = Integer.parseInt(parts2[0]);
		 int memory = Integer.parseInt(parts2[1]);
		 PCB pcb = new PCB(id, burstTime, memory);
		 jobQueue.add(pcb);
		 }
		 br.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 });
		
		 // Thread for loading jobs to ready queue
		 Thread loadThread = new Thread(() -> {
		 while (true) {
		 if (!jobQueue.isEmpty() && availableMemory >= jobQueue.peek().memory) {
		 PCB pcb = jobQueue.poll();
		 readyQueue.add(pcb);
//		 availableMemory -= pcb.memory;
		 }
		 }
		 });
		
		 // Main thread for scheduling
		 Thread scheduleThread = new Thread(() -> {
		 Scanner input = new Scanner(System.in);
		 System.out.println("Select a scheduling algorithm: ");
		 System.out.println("1. First-Come-First-Serve (FCFS)");
		 System.out.println("2. Shortest-Job-First (SJF)");
		 System.out.println("3. Round-Robin (RR)");
		 int algorithm = input.nextInt();
		
		 switch (algorithm) {
		 case 1:
		 FCFS(readyQueue);
		 break;
		 case 2:
		 SJF(readyQueue);
		 break;
		 case 3:
		 RR(readyQueue, 10);
		 break;
		 default:
		 System.out.println("Invalid selection.");
		 break;
		 }
		 });
		
		 // Start threads
		 fileThread.start();
		 loadThread.start();
		 scheduleThread.start();
		 }
		
		 public static void FCFS(Queue<PCB> readyQueue) {
		 int currentTime = 0;
		 int totalTurnaroundTime = 0;
		 int totalWaitingTime = 0;
		 while (!readyQueue.isEmpty()) {
		 PCB pcb = readyQueue.poll();
		 int turnaroundTime = currentTime + pcb.burstTime - pcb.arrivalTime;
		 int waitingTime = currentTime - pcb.arrivalTime;
		 totalTurnaroundTime += turnaroundTime;
		 totalWaitingTime += waitingTime;
		 currentTime += pcb.burstTime;
		 System.out.println("Process ID: " + pcb.id + " Burst Time: " + pcb.burstTime + " Turnaround Time: " + turnaroundTime + " Waiting Time: " + waitingTime);
		 }
		 System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / readyQueue.size());
		 System.out.println("Average Waiting Time: " + (double) totalWaitingTime / readyQueue.size());
		 }
		
		 public static void SJF(Queue<PCB> readyQueue) {
		 int currentTime = 0;
		 int totalTurnaroundTime = 0;
		 int totalWaitingTime = 0;
		 while (!readyQueue.isEmpty()) {
		 PCB pcb = readyQueue.poll();
		 int minBurstTime = Integer.MAX_VALUE;
		 PCB minPCB = null;
		 for (PCB p : readyQueue) {
		 if (p.burstTime < minBurstTime) {
		 minBurstTime = p.burstTime;
		 minPCB = p;
		 }
		 }
		 readyQueue.remove(minPCB);
		 int turnaroundTime = currentTime + minPCB.burstTime - minPCB.arrivalTime;
		 int waitingTime = currentTime - minPCB.arrivalTime;
		 totalTurnaroundTime += turnaroundTime;
		 totalWaitingTime += waitingTime;
		 currentTime += minPCB.burstTime;
		 System.out.println("Process ID: " + minPCB.id + " Burst Time: " + minPCB.burstTime + " Turnaround Time: " + turnaroundTime + " Waiting Time: " + waitingTime);
		 }
		 System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / readyQueue.size());
		 System.out.println("Average Waiting Time: " + (double) totalWaitingTime / readyQueue.size());
		 }
		
		 public static void RR(Queue<PCB> readyQueue, int quantum) {
		 int currentTime = 0;
		 int totalTurnaroundTime = 0;
		 int totalWaitingTime = 0;
		 while (!readyQueue.isEmpty()) {
		 PCB pcb = readyQueue.poll();
		 int burstTime = pcb.burstTime;
		 if (burstTime > quantum) {
		 burstTime = quantum;
		 pcb.burstTime -= quantum;
		 readyQueue.add(pcb);
		 }
		 int turnaroundTime = currentTime + burstTime - pcb.arrivalTime;
		 int waitingTime = currentTime - pcb.arrivalTime;
		 totalTurnaroundTime += turnaroundTime;
		 totalWaitingTime += waitingTime;
		 currentTime += burstTime;
		 }
		 System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / readyQueue.size());
		 System.out.println("Average Waiting Time: " + (double) totalWaitingTime / readyQueue.size());
		 }
		}
		
		class PCB {
		 int id;
		 int burstTime;
		 int memory;
		 int arrivalTime = 0;
		
		 public PCB(int id, int burstTime, int memory) {
		 this.id = id;
		 this.burstTime = burstTime;
		 this.memory = memory;
		 }
		}
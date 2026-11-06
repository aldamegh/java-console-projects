
import java.io.; 
import java.util.; 
  
public class Main { 

    public static final int MAXMEMORY = 1024;  // Memory size of main memory in KB 
 public static final int QUANTUMTIME = 10; // Quantum time per RR- 10 algorithm

 public static void main(String args) throws FileNotFoundException {

        Scanner inputFile = new Scanner(new File("jobs.txt"));   //Scanning from file 'job.txt'

        //Class Variables 
        JobQueue queue = new JobQueue();
        PCB readyQueueHead = null, tempReadyQueueHead;  //Pointer to respectively ready queue head and temp pointer to it for manipulation.
  int algorithmChoice, processRunTime, currentTime=0, allocatedMemory=0;  //Algorithm choice and recorded run-time of the job running at each iteration respectively and currentTime keeps track of system time and allocatedMemory variable keeps track of total memory currently used.
        
        while (inputFile.hasNext()) {                  //Iterates over inputfile jobs till a line ends or reach end of the file.           
           String line = inputFile.nextLine().split(":");    //Split inputs by ":" delimeter every iteration as specified in inputFile structure lines0 containing Process ID and lines1 containing Burst Time/Required Memory respectively with ";" as delimeted before it. 

           //Add to jobqueue Add job(s) to linked-list based that forms the job-queue and increment the total allocated memory throughout all processes  
            queue.addJobToJobQueue(Integer.parseInt(line0), Integer.parseInt(line1.split(";")0), Integer.parseInt(line1.split(";")1));     //Adding newly created Process Control Blocks (PCBs) to job queue linked-list data structure only when sufficient amount of space is left in the main memory considering previously allocated jobs accepted in same batch if any being taken into account too, updating allocatedMemory on go along with allocating more memory accordingly through adding up each processes required memory sizes simultaneously for tracking proper usage throughout the execution process however updates to PCB object parameters will be further refined lateronce individual processes executed by algorithms instead until enough space exists or isn't plus filtering redundant steps out from implementation code making easier readability preventing stuffing up function wtih too many confusing operations combined altogether both logically + technically speaking for avoiding common risks causing critical issues on final delivery output once finally internal bug testing eventually complated etc..     

            / Skip resetting rest of existing active process parameters values since as its newly created only once here no need perform extra tampering/manipulation over parts written post this block /          }

       System.out.println("Welcome to my Scheduling Simulator | Place an integer value -> 1 to 3 respectivel (or q / quit )y based on algorithms: -\n INSTRUCTIONS: \n >> FCFS - First Come First Serve \n >>SJF - Shortest Job First\n >>RR10 - Round Robin 10ms Quanatum");     / Display interactive instruction & prompts enabling user input selecting respective algorithm per his/her choice /  

       while (!((algorithmChoice=new Scanner(System.in).nextInt()) > 0 && algorithmChoice < 4))    //Take valid user input between 1 – 3 only ('q' excluded!).              ;//flushing pseudo-code template layout           \u0020                                       \u0020   
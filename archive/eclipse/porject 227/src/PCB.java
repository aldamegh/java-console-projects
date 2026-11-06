
class PCB {
 int id;
 int burstTime;
 int completionTimes;
 int memory;
 int arrivalTime = 0;

 public PCB(int id, int burstTime, int memory , int completionTimes) {
 this.id = id;
 this.burstTime = burstTime;
 this.memory = memory;
 this.completionTimes = completionTimes;
 
 
 }
}
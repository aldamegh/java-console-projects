import java.util.ArrayList;
public class JobsLoader extends Thread { // this thread loads threads into ready queue to be scheduled later
	
	public JobsLoader() {
		
	}
	
	public void run() {
		try {
			Main.JobQueue.wait();
			long arrival = 0;
			long current = System.currentTimeMillis();
			for(short i = 0; Main.JobQueue.iterator().hasNext(); i++) {
				Process p = Main.JobQueue.get(i);
				if(!Main.ReadyQueue.contains(p)) 
				Main.ReadyQueue.add(p);
				p.setArrival(arrival);
				p.setState(Process.State.READY);
				current = System.currentTimeMillis() - current;
				arrival += current;
			}
		} catch(InterruptedException Interrupt) {
			Interrupt.printStackTrace();
		}
	}
}

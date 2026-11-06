import java.util.ArrayList;
import java.lang.Math;
public class ReadyQueueScheduler extends Thread {
    public String SchAlg;
	public ReadyQueueScheduler(String alg) {
		super();
		SchAlg = alg;
	}
	
	public void run() {
			if(SchAlg.equalsIgnoreCase("f")) Main.FCFS();
			else if(SchAlg.equalsIgnoreCase("s")) Main.SJF();
			else if(SchAlg.equalsIgnoreCase("r")) Main.RR();
	}
    
	
}

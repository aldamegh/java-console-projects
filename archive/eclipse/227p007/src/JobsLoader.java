import java.util.ArrayList;
public class JobsLoader extends Thread { // this thread loads threads into ready queue to be scheduled later
	
	public JobsLoader() {
		System.out.println("IN JL1");
		
		 boolean k = true;
			for(int i=0;i<1;) {
				
				if(Process.Pkey!=0) i++;
			
		
			}
//		int x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
//		 x=1;	
//		while(x<2000000) {
//			x += 1;
//		}
//		x=1;
//		while(x<2000000) {
//			x += 1;
//		}
	}
	
	
	public void run() {
		
		System.out.println("IN JL2");
			long arrival = 0;
			long current = System.currentTimeMillis();
			for(short i = 0; i < Main.numOfProcesses; i++) {
				System.out.println("IN JL"+i);
				Process p = Main.JobQueue.get(i);
				if(!Main.ReadyQueue.contains(p)) 
					Main.ReadyQueue.add(p);
				p.setArrival(arrival);
				p.setState(Process.State.READY);
				current = System.currentTimeMillis() - current;
				arrival += current;
			}
			System.out.println("Stop JL");
//			Process.Pkey=2;
	}
}

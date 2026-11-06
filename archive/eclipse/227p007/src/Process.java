import java.lang.Double;
import java.lang.Integer;
public class Process {

	private long BurstTime; // in milliseconds.
	
	private long WaitTime; // in milliseconds
	
	private final double MemorySize; // in megabytes
	
	private final long ID;
	
	private long Arrival; // in milliseconds
	
	private long Termination; // in milliseconds
	
	private State state;
	
	static int  Pkey = 0;
	
	public static enum State {
		NEW, READY, RUNNING, WAITING, TERMINATED
	}
	
	
	public Process(String Time, String Size, String Id) {
		BurstTime = Integer.parseInt(Time);
		MemorySize = Double.parseDouble(Size);
		ID = Integer.parseInt(Id);
		Arrival = Termination = 0;
		state = State.NEW;
		
		
	}
	
	public long getBurst() {
		return BurstTime;
	}
	
	public double getMemory() {
		return MemorySize;
	}
	
	public long getID() {
		return ID;
	}
	
	public long getArrival() {
		return Arrival;
	}
	
	public long getTermination() {
		return Termination;
	}
	
	public State getState() {
		return state;
	}
	
	public long getWait() {
		return WaitTime;
	}
	
	public void setArrival(long ar) {
		Arrival = ar;
	}
	
	public void setTermination(long tr) {
		Termination = tr;
	}
	
	public void setState(State St) {
		state = St;
	}
	
	public void setWait(long w) {
		WaitTime = w;
	}
	
	public void setBurst(long B) {
		BurstTime = B;
	}

	
}

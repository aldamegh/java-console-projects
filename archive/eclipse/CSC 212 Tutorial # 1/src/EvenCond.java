import java.util.concurrent.locks.Condition;

public class EvenCond implements Condition<Integer> {

	public boolean test (Integer n) {
		
		return n%2 == 0;
	}

}

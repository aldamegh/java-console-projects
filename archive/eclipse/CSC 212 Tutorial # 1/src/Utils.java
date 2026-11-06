import java.util.concurrent.locks.Condition;

public class Utils {

	public static <T> int search (T[] data , int n, Condition<T> cond) {
		
		for (int i=0 ; i<n ; i++) {
			
			if (cond.test(data[i]))
				return i;
		}
				return -1;
	}

	public static int searchEven (Integer[] data, int n) {
		
		EvenCond ec = new EvenCond();
		
		return Utils.searchEven(data, n, ec);
		
	}
}

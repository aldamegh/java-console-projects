import java.util.List;

public class Problem1 {

	public static <T> void CLS(List<T> l, int n) {
		l.findFirst();
		
		for (int i=0; i <n; i++) {
			l.findFirst();
			T e = l.retrieve();
			l.remove();
			while (!l.last())
				l.findNext();
			l.insert(e);
		}
	}
}

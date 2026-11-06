
public class Problem2 {

	public T mFE() {
		T mfe = null; 
		int max = 0; Node<T> p = head;
		while (p != null) {
			Node<T> (p != null){
				Node<T> q = p;
				int count = 0; 
				while (q != null ) {
					if (q.data.euals(p.data))
						count++; 
					q = q.next; 
				}
				if (cont > max) {
					
					max = count;
					mfe = p.data;
				}
				p = p.next; 
				}
			return mfe;
		}
	}
}

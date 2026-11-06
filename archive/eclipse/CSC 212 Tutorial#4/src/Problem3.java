
public class Problem3 {

	public void removeBetween(T e1, T e2) {
		Node<T> p = head ; 
		while ((p != null) && (!p.data.equals(e1)))
			p = p.next; 
		if (p == null)
			return; 
		Node<T> q = p.next;
		while ((q != null ) && (!q.data.equals(e2)))
			q = q.next; if (q == null)
				return ;
			p.next = q;
			q.previous = p;
			current = head;
	}
}

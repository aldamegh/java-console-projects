class BSTSetNode<K extends Comparable<K>> {
	public K key;
	public BSTSetNode<K> left, right, next, prev;
	

	public BSTSetNode(K key) {
		this.key = key;
		left = right = next = prev = null;
	}
}
class setItertor<T extends Comparable<T>> implements Iterator<T> {
		public BSTSetNode<T> node;
	public setItertor(BSTSetNode<T> p) {
		node = p;
	}

	public boolean isValid() {
		if (node == null)
			return false;
		else
			return true;
	}

	public T next() {
		if (node != null) {
			T key = node.key;
			if (node.left == null)
				node = node.right;
			else 
				node = node.left;
			return  key;
			}
		else
			return null;
	}

	public T prev() {
		if (node != null) {
			T key = node.key;
			if (node.left == null)
				node = node.right;
			else 
				node = node.left;
			return  key;
			}
		else
			return null;
	}
}
 
	public class BSTSet<K extends Comparable<K>> implements Set<K> {
		public BSTSetNode<K> root; // Do not change this
	
	public int size;
	private  int indexk;
	private int [] arrlist;
	private int [] arrvalue;
	BSTSet<Integer>  t ;

	public BSTSet() {
		root = null;
		size = 0;
		indexk = 0;
		t = null;
	}

	// Return the size of the set.
	public int size() {
		return size;
	}

	// Return true if the set is full.
	public boolean full() {
		if (size == 13) {
			return true;
		}else {
		return false;
		}
	}

	//Remove all keys from the set .
	public void clear() {
		root = null;
		size = 0;
	}

	

	// Search for the key k and return true if it exists, false otherwise.
	public boolean exists(K k) {
		if (root == null)
			return false;
		BSTSetNode<K> p = root;
		
		while (p != null) {
			if (k.compareTo(p.key) == 0) {
				return true;
				} 
			else if (k.compareTo(p.key) > 0)
				p = p.right;
			else if (k.compareTo(p.key) < 0)
				p = p.left;
		}
		return false;

	}
	


	// Insert a new key if does not exist and return true . If k already
	//exists , return false .

	public boolean insert(K k) {
		BSTSetNode<K> node = new BSTSetNode<K>(k);
		if (root == null) {
			root = node;
			size++;
			return true;
		}
		BSTSetNode<K> p = root;
		boolean flag = false;
		boolean flag2 = false;
		while (p != null) {
			if (k.compareTo(p.key) == 0) {
				flag = true;
				break;
			} else if (k.compareTo(p.key) > 0) {
				if (p.right == null) {
					flag2 = true;
					break;
				}
				p = p.right;
			} else {
				if (p.left == null)
					break;
				p = p.left;
			}
		}
		if (flag)
			return false;
		if (flag2)
			p.right = node;
		else
			p.left = node;
		size++;
		return true;
	}

	// Remove the key k if it exists and return true . If the key does not
	//exist return false
	public boolean remove(K k) {
		if (root == null)
			return false;

		K k1 = k;
		BSTSetNode<K> p = root;
		BSTSetNode<K> q = null; // Parent of p
		while (p != null) {
			if (p.key.compareTo(k1) > 0) {
				q = p;
				p = p.left;
			} else if (k1.compareTo(p.key) > 0) {
				q = p;
				p = p.right;
			} else { // Found the key
						// Check the three cases
				if ((p.left != null) && (p.right != null)) {
					// Case 3: two children
					// Search for the min in the right subtree
					BSTSetNode<K> min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					
					k1 = min.key;
					p = min;
					// Now fall back to either case 1 or 2
				}

				// The subtree rooted at p will change here
				if (p.left != null) { // One child
					p = p.left;
				} else { // One or no children
					p = p.right;
				}

				if (q == null) { // No parent for p, root must change
					root = p;
				} else {
					if (q.key.compareTo(k1) > 0) {
						q.left = p;
					} else {
						q.right = p;
					}
				}
				size--;
				return true;

			}
		}

		return false; // Not found
	}

	

	
	public Iterator<K> minIt() {
		if (root == null)
			return null;
		BSTSetNode<K> p = root;
		arrlist = new int[size];
		arrvalue = new int[size];
		indexk = 0;
		minR(p);
		
		
		t = new BSTSet<Integer>();
	
		for (int j = 0; j< size; j++) {
			
			t.insert(arrlist[j]);
		
			
		}
		BSTSetNode<K> mp = (BSTSetNode<K>) t.root;

		return  (Iterator<K>) new  setItertor<K>(mp);
		
	}

	private void minR(BSTSetNode<K> p ) {
		if (p == null)
			return;
		minR(p.left);
		arrlist[indexk] = (int) p.key;
		
		indexk = indexk +1;
		minR(p.right);
	}
	
	public Iterator<K> maxIt() {

		
		if (root == null)
			return null;
		BSTSetNode<K> p = root;
		arrlist = new int[size];
		arrvalue = new int[size];
		indexk = 0;
		minR(p);
			
		t = new BSTSet<Integer>();
		
		for (int j = size-1; j >=0; j--) {
		
			t.insert(arrlist[j]);
			
			
		}
			
		BSTSetNode<K> mp = (BSTSetNode<K>) t.root;
	
		return  (Iterator<K>) new  setItertor<K>(mp);
		
	}
	
//	private void maxR(BSTMapNode<K,T> p ) {
//		if (p == null)
//			return;
//		maxR(p.right);
//		arrlist[indexk] = (int) p.key;
//		arrvalue[indexk] = (int) p.data;
//		indexk = indexk +1;
//		maxR(p.left);
//	}

}	


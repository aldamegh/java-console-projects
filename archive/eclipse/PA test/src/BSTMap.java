class BSTMapNode<K extends Comparable<K>, T> {
	public K key;
	public T data;
	public BSTMapNode<K, T> left, right, next, prev;

	public BSTMapNode(K key, T data) {
		this.key = key;
		this.data = data;
		left = right = next = prev = null;
	}
}

 class mapItertor<K extends Comparable<K>,T> implements Iterator<T> {
	public BSTMapNode<K, T> node;
	
	public mapItertor(BSTMapNode<K, T> p) {
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
			Pair<K,T> item = new Pair<K,T>(node.key,node.data);
			if (node.left == null)
				node = node.right;
			else 
				node = node.left;
			return (T) item;
			}
		else
			return null;
	}

	public T prev() {
		if (node != null) {
			Pair<K,T> item = new Pair<K,T>(node.key,node.data);
			if (node.left == null)
				node = node.right;
			else 
				node = node.left;
			return (T) item;
			}
		else
			return null;
	}
}
 
public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTMapNode<K, T> root; // Do not change this
	
	public int size;
	private  int indexk;
	private int [] arrlist;
	private int [] arrvalue;
	BSTMap<Integer, Integer>  t ;

	public BSTMap() {
		root = null;
		size = 0;
		indexk = 0;
		t = null;
	}

	// Return the size of the map.
	public int size() {
		return size;
	}

	// Return true if the map is full.
	public boolean full() {
		if (size == 13) {
			return true;
		}else {
		return false;
		}
	}

	// Remove all elements from the map.
	public void clear() {
		root = null;
		size = 0;
	}

	// Update the data of the key k if it exists and return true. If k does not
	// exist, the method returns false.
	public boolean update(K k, T e) {
		if (root == null)
			return false;
		BSTMapNode<K, T> p = root;
		boolean flag = false;
		while (p != null) {
			if (k.compareTo(p.key) == 0) {
				p.data = e;
				flag = true;
				break;
			} else if (k.compareTo(p.key) > 0)
				p = p.right;
			else if (k.compareTo(p.key) < 0)
				p = p.left;
		}
		return flag;
	}

	// Search for element with key k and returns a pair containing true and its data
	// if it exists. If k does not exist, the method returns false and null.
	public Pair<Boolean, T> retrieve(K k) {
		if (root == null)
			return new Pair<Boolean, T>(false, null);
		BSTMapNode<K, T> p = root;
		boolean flag = false;
		while (p != null) {
			if (k.compareTo(p.key) == 0) {
				flag = true;
				break;
			} else if (k.compareTo(p.key) > 0)
				p = p.right;
			else if (k.compareTo(p.key) < 0)
				p = p.left;
		}
		if (p == null)
			return new Pair<Boolean, T>(flag, null);
		return new Pair<Boolean, T>(flag, p.data);
	}


	// Insert a new element if does not exist and return true. If k already exists,
	// return false.
	public boolean insert(K k, T e) {
		BSTMapNode<K, T> node = new BSTMapNode<K, T>(k, e);
		if (root == null) {
			root = node;
			size++;
			return true;
		}
		BSTMapNode<K, T> p = root;
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

	// Remove the element with key k if it exists and return true. If the element
	// does not exist return false.
	public boolean remove(K k) {
		if (root == null)
			return false;

		// Search for k
		K k1 = k;
		BSTMapNode<K, T> p = root;
		BSTMapNode<K, T> q = null; // Parent of p
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
					BSTMapNode<K, T> min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					p.data = min.data;
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

	

	
	public Iterator<Pair<K, T>> minIt() {
		if (root == null)
			return null;
		BSTMapNode<K, T> p = root;
		arrlist = new int[size];
		arrvalue = new int[size];
		indexk = 0;
		minR(p);
		
		
		t = new BSTMap<Integer, Integer>();
	
		for (int j = 0; j< size; j++) {
			
			t.insert(arrlist[j], arrvalue[j]);
		
			
		}
		BSTMapNode<K, T> mp = (BSTMapNode<K, T>) t.root;

		return  (Iterator<Pair<K, T>>) new  mapItertor<K,T>(mp);
		
	}

	private void minR(BSTMapNode<K,T> p ) {
		if (p == null)
			return;
		minR(p.left);
		arrlist[indexk] = (int) p.key;
		arrvalue[indexk] = (int) p.data;
		indexk = indexk +1;
		minR(p.right);
	}
	
	public Iterator<Pair<K, T>> maxIt() {

		
		if (root == null)
			return null;
		BSTMapNode<K, T> p = root;
		arrlist = new int[size];
		arrvalue = new int[size];
		indexk = 0;
		minR(p);
			
		t = new BSTMap<Integer, Integer>();
		
		for (int j = size-1; j >=0; j--) {
		
			t.insert(arrlist[j], arrvalue[j]);
			
			
		}
			
		BSTMapNode<K, T> mp = (BSTMapNode<K, T>) t.root;
	
		return  (Iterator<Pair<K, T>>) new  mapItertor<K,T>(mp);
		
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


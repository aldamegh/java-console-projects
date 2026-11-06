
public class ArrayPQK<P extends Comparable<P>, T> implements PQK<P, T> {
	private Pair<P, T>[] heap;
	private int size;

	
	
	public ArrayPQK(int k) {
		heap = (Pair<P, T>[]) new Pair[k];
		size = 0;
	}

	
	public int length() {
		return size;
	}

	
	public void enqueue(P pr, T e) {
		// if queue is full, replace the element with least priority with the given element if it has higher priority
		if (size == heap.length){
			// find the element to replace
			int maxIndex = 0;
			for (int j = 1; j < size; j++){
				if (heap[j].first.compareTo(heap[maxIndex].first) < 0){
					maxIndex = j;
				}
			}
			if (heap[maxIndex].first.compareTo(pr) < 0){
				heap[maxIndex] = new Pair<P, T>(pr, e);
				bubbleUp(maxIndex);
			}
		}
		else{
			heap[size] = new Pair<P, T>(pr, e);
			bubbleUp(size);
			size++;
		}
	}

	
	public Pair<P, T> serve() {
		Pair<P, T> p = heap[0];
		// check if next has same priority
		int i;
		for (i = 1; i < size && heap[i].first.compareTo(p.first) == 0; i++){
			heap[i-1] = heap[i];
		}
		heap[i-1] = heap[size -1];
		heap[size - 1] = null;
		size--;
		trickleDown(i-1);
		return p;
	}

	private void bubbleUp(int i) {
		while (i > 0 && heap[i].first.compareTo(heap[getParent(i)].first) > 0) {
			swap(i, getParent(i));
			i = getParent(i);
		}
	}

	private void trickleDown(int i) {
		int left = getLeft(i);
		int right = getRight(i);
		int largest = i;
		if (left < size && heap[left].first.compareTo(heap[largest].first) > 0) {
			largest = left;
		}
		if (right < size && heap[right].first.compareTo(heap[largest].first) > 0) {
			largest = right;
		}
		if (largest != i) {
			swap(i, largest);
			trickleDown(largest);
		}
	}

	private void swap(int i, int largest) {
		Pair<P, T> temp = heap[i];
		heap[i] = heap[largest];
		heap[largest] = temp;
	}

	private int getLeft(int index) {
		return 2 * index + 1;
	}

	private int getRight(int index) {
		return 2 * index + 2;
	}

	private int getParent(int index) {
		return (index - 1) / 2;
	}

}

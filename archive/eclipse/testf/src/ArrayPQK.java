public class ArrayPQK <P extends Comparable<P>, T> implements PQK<P, T> {
	
	//class to store information of a node
	public class Item {
		
	    P priority;
	    
	    T name;
	    
	    
	    //Parameterized constructor
	    public Item(P p, T e) {
	    
	    	this.priority = p;
	    	
	    	this.name = e;
	    }
	    //copy constructor
	    public Item(Item another) {
	        
	    	this.priority = another.priority; 
	        
	    	this.name = another.name;
	      }
	}
	
	// array to tore items in the priority queue
	Item[] arr;
	//count of current items in the priority queue
	int count;
	
	//size of queue
	int size;
	
	
	
	//Parameterized constructor
	public ArrayPQK(int k) {
		this.size = k;
		
		arr = new ArrayPQK.Item[k];
		
		count = 0;
	}
	
	
	// Return the length of the queue
	public int length() {
		
		return count;
	}

	// Enqueue a new element. The queue keeps the k elements with the highest priority.
	public void enqueue(P pr, T e) {
		int i;
		
		//if queue is empty then add the element
		if(count < size) {
			
			arr[count] = new Item(pr, e);
			
			count++;
		}
		//identify the correct position
		else if( arr[size-1].priority.compareTo(pr)==-1) {
							
					arr[size-1].priority = pr;
					
					arr[size-1].name = e;
										
		}
			
		//Building k-max heap	
		for(int j = 0; j <count; j++) {
			
			Item max1 = new Item(arr[j].priority, arr[j].name);
		    
			int maxIndex = j;
			
			for(int  k= j+1; k <count; k++) {
				
				if(max1.priority.compareTo(arr[k].priority)==-1) {
						
						max1.priority = arr[k].priority;
				
						max1.name = arr[k].name;
					    
						maxIndex = k;
				}
			
			}
			arr[maxIndex].priority = arr[j].priority;
			
			arr[maxIndex].name = arr[j].name;
			
			arr[j] = max1;
		}
			
		
	
		
		
		
		
	}

	// Serve the element with the highest priority. In case of a tie apply FIFO.
	public Pair<P, T> serve(){
		
		Pair<P, T> p = new Pair<P,T>(arr[0].priority , arr[0].name);
		
		count--;
		
		
		for(int k = 0; k <count; k++) {
					
			arr[k].priority = arr[k+1].priority;
	
			arr[k].name = arr[k+1].name;
		
		}
		
		return p;
	}

}
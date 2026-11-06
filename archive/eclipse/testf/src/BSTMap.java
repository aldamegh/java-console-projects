public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
	public BSTMapNode<K, T> root; // Do not change this
    int size;
    BSTMap<K, T>.MinIterator min_iter;
    MaxIterator max_iter;
    
    ///////////////////////////////////////  ---- CLASS Stack ---------- /////////////////////////////////////////////
    class Stack
    {
        public BSTMapNode<K, T>[] data;
        
        public int head;
        
        public int size;
     
      
        Stack(int s)
        {
            data = (BSTMapNode<K, T>[] ) new BSTMapNode[s];
            
            size = s;
            
            head = -1;
        }
     
        
        public void push(BSTMapNode<K, T> x)
        {
        	data[++head] = x;
        }
     
       
        public BSTMapNode<K, T> pop()
        {
            
            if (isEmpty())
            {
                return null;
            }
     
     
            return data[head--];
        }
     
       
        public BSTMapNode<K, T> peek()
        {
            if (!isEmpty()) {
                return data[head];
            }
          
            return null;
        }
     
  
        public boolean isEmpty() {
            return head == -1;              
        }
     
    }
    
class MaxIterator implements Iterator<Pair<K, T>> {

    	
    	Stack s;
		private BSTMapNode<K, T> root;

        public MaxIterator(BSTMapNode<K,T> root){
            s = new Stack(999999);
        	this.root = root;
            add_to_stack(root);
        }
        
        public Pair<K,T> next() {
        	
        	BSTMapNode<K,T> node = s.pop();
        	
        	if(s== null)
        	
        		return null;
        	
        	Pair<K,T> r =  new Pair<K,T>(node.key, node.data);
			
        	return r;
			
        }
        
        public void add_to_stack(BSTMapNode<K,T> node) {
        	
        	if (node == null)
     
        		return;
             
        	add_to_stack(node.left);
               
            s.push(node);
 
            add_to_stack(node.right);
        }

		@Override
		public boolean isValid() {
			// TODO Auto-generated method stub
			if(s.isEmpty())
				return false;
			return true;
		}

		@Override
		public Pair<K, T> prev() {
			BSTMapNode<K,T> node = s.pop();
        	
        	if(s== null)
        	
        		return null;
        	
        	Pair<K,T> r =  new Pair<K,T>(node.key, node.data);
			
        	return r;
			
		}
    }

    
    class MinIterator implements Iterator<Pair<K, T>> {

    	
    	Stack s;
		private BSTMapNode<K, T> root;

        public MinIterator(BSTMapNode<K,T> root){
        	
        	this.root = root;
        	
        	s = new Stack(999999);
            
            add_to_stack(root);
        }
        
        public Pair<K,T> next() {
        	
        	BSTMapNode<K,T> node = s.pop();
        	
        	if(s== null)
        	
        		return null;
        	
        	Pair<K,T> r =  new Pair<K,T>(node.key, node.data);
			
        	return r;
			
        }
        
        public void add_to_stack(BSTMapNode<K,T> node) {
        	
        	if (node == null)
     
        		return;
             
        	add_to_stack(node.right);
               
            s.push(node);
 
            add_to_stack(node.left);
        }

		@Override
		public boolean isValid() {
			// TODO Auto-generated method stub
			if(s.isEmpty())
				return false;
			return true;
		}

		@Override
		public Pair<K, T> prev() {
			// TODO Auto-generated method stub
			return null;
		}
    }
        
    
    @Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean full() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		size =0;
		root = null;
		
	}

	@Override
	public boolean update(K k, T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pair<Boolean, T> retrieve(K k) {
		
		return null;
	
	}
    
	
	public BSTMapNode<K,T> get(BSTMapNode<K,T> node, K k) {
		
		if(node ==null)
			return null;
		
		else if(node.key.compareTo(k)== -1){
			return get(node.right, k);
		}
		else if(node.key.compareTo(k)== 1){
	    	 return get(node.left, k);
		}
		return node;
	}
	
	//BST creation
	BSTMapNode<K,T> add(BSTMapNode<K,T> node, K k, T e) {
    	
		
    	if( node == null) {
    		
    		return new BSTMapNode<K, T>(k, e);
    	
    		
    	}
    	
    	else if(node.key.compareTo(k)==-1) {
    		node.right = add(node.right,k, e);
    	}
    	else if(node.key.compareTo(k)==1) {
    		node.left = add(node.left,k, e);
    	}
    	//System.out.println("\nNode Key: "+node.key+" Key: "+k+" compare result: "+node.key.compareTo(k)+"\n");
    	return node;
    	
    }
	@Override
	public boolean insert(K k, T e) {
		    BSTMapNode<K,T> r = add(root , k, e);
		    if(root==null)root = r;
			if(r== null) {
				
				return false;
			}
			else {
				
				return true;
			}
			
		
	}

	@Override
	public boolean remove(K k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Pair<K, T>> minIt() {
		min_iter= new MinIterator(this.root);
		
		return min_iter;
	}

	@Override
	public Iterator<Pair<K, T>> maxIt() {

		max_iter= new MaxIterator(this.root);
		return max_iter;
		
	}

}

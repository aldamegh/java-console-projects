
public class BSTSet<K extends Comparable<K>> implements Set<K> {
	public BSTSet<K> root1; // Do not change this
	BSTSetNode<K> root;
	int size;
	MinIterator min_iter;
    MaxIterator max_iter;
    ///////////////////////////////////////  ---- CLASS Stack ---------- /////////////////////////////////////////////
	    class Stack
	    {
	        public BSTSetNode<K>[] data;
	        
	        public int head;
	        
	        public int size;
	     
	      
	        Stack(int s)
	        {
	            data = (BSTSetNode<K>[]) new BSTSetNode[s];
	            
	            size = s;
	            
	            head = -1;
	        }
	     
	        
	        public void push(BSTSetNode<K> x)
	        {
	        	data[++head] = x;
	        }
	     
	       
	        public BSTSetNode<K> pop()
	        {
	            
	            if (isEmpty())
	            {
	                return null;
	            }
	     
	     
	            return data[head--];
	        }
	     
	       
	        public BSTSetNode<K> peek()
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
	    
	    class MaxIterator implements Iterator<K> {

	        	
	        	Stack s;
	    		private  BSTSetNode<K> root;

	            public MaxIterator( BSTSetNode<K> root){
	                s = new Stack(999999);
	            	this.root = root;
	                add_to_stack(root);
	            }
	            
	            public K next() {
	            	
	            	BSTSetNode<K> node = s.pop();
	            	
	            	if(s== null)
	            	
	            		return null;
	            	
	            	K r =  node.key;
	    			
	            	return r;
	    			
	            }
	            
	            public void add_to_stack( BSTSetNode<K> node) {
	            	
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
	    		public K prev() {
	    			BSTSetNode<K> node = s.pop();
	            	
	            	if(s== null)
	            	
	            		return null;
	            	
	            	K r =  node.key;
	    			
	            	return r;
	    			
	    		}
	        }
	    class MinIterator implements Iterator<K> {

        	
        	Stack s;
    		private  BSTSetNode<K> root;

            public MinIterator( BSTSetNode<K> root){
                s = new Stack(999999);
            	this.root = root;
                add_to_stack(root);
            }
            
            public K next() {
            	
            	BSTSetNode<K> node = s.pop();
            	
            	if(s== null)
            	
            		return null;
            	
            	K r =  node.key;
    			
            	return r;
            }
            
            public void add_to_stack( BSTSetNode<K> node) {
            	
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
    		public K prev() {
    			
    			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(K k) {
		// TODO Auto-generated method stub
		return false;
	}

	//BST creation
		BSTSetNode<K> add(BSTSetNode<K> node, K k) {
	    	
			
	    	if( node == null) {
	    		
	    		return new BSTSetNode<K>(k);
	    	
	    		
	    	}
	    	
	    	else if(node.key.compareTo(k)==-1) {
	    		node.right = add(node.right,k);
	    	}
	    	else if(node.key.compareTo(k)==1) {
	    		node.left = add(node.left,k);
	    	}
	    	
	    	return node;
	    	
	    }
	@Override
	public boolean insert(K k) {
		 BSTSetNode<K> r = add(root , k);
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
	public Iterator<K> minIt() {
		min_iter= new MinIterator(this.root);
		
		return min_iter;
	}

	@Override
	public Iterator<K> maxIt() {

		max_iter= new MaxIterator(this.root);
		return max_iter;
		
	}
	
}

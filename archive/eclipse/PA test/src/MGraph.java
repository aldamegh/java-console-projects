public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Set<K> nodes; // Do not change this
	public Map<K, Set<K>> adj ; // Do not change this
	
	public MGraph() {
		nodes = new BSTSet<K>();
		adj = new BSTMap<K, Set<K>>();
	}

	
	// Add a node to the graph if it does not exist and return true. If the node
	// already exists, return false.
	public boolean addNode(K i) {
		if (isNode(i))
			return false;
		nodes.insert(i);
		return true;
	}
	
	// Check if i is a node
	public boolean isNode(K i) {
		return nodes.exists(i);
	}
	
	// Add an edge to the graph if it does not exist and return true. If i or j do
	// not exist or the edge (i, j) already exists, return false.
	public boolean addEdge(K i, K j) {
		if (!isNode(i) || !isNode(j)|| isEdge(i,j)){
			return false;
		}
		if (!adj.retrieve(i).first) {
			adj.insert(i, new BSTSet<K>());
		}
		if (!adj.retrieve(j).first) {
			adj.insert(j, new BSTSet<K>());
		}

		Set<K> set = adj.retrieve(i).second;
		Set<K> set2 = adj.retrieve(j).second;
		return set.insert(j) && set2.insert(i);
	}
	
	// Check if (i, j) is an edge.
	public boolean isEdge(K i, K j) {
		if (!isNode(i) || !isNode(j))
			return false;
		if (!adj.retrieve(i).first) {
			return false;
		}
		Set<K> set = adj.retrieve(i).second;
		return set.exists(j);
	}
	
	// Return the set of neighbors of node i. If i does not exist, the method
	// returns null.
		public Set<K> neighb(K i) {
		if (!isNode(i))
			return null;
		return adj.retrieve(i).second;
	}
	
	// Return the degree (the number of neighbors) of node i. If i does not exist,
	// the method returns -1.
	public int deg(K i) {
		if (!isNode(i))
			return -1;
		return adj.retrieve(i).second.size();
	}

	
	@Override
	public Iterator<K> nodesIt() {
		return nodes.minIt();
	}


}


public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Set<K> nodes; // Do not change this
	public Map<K, Set<K>> adj; // Do not change this
	
	MGraph(){
		adj = new BSTMap<K, Set<K>>();
		nodes = new BSTSet<K>();
		
	}
	@Override
	public boolean addNode(K i) {
		return nodes.insert(i);
	
	}
	@Override
	public boolean isNode(K i) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean addEdge(K i, K j) {
		return false;
		//return adj.insert(i,j);
	
	}
	@Override
	public boolean isEdge(K i, K j) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Set<K> neighb(K i) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deg(K i) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public Iterator<K> nodesIt() {
		// TODO Auto-generated method stub
		return null;
	}

}

public class MGraph<K extends Comparable<K>> implements Graph<K> {
	public Set<K> nodes; // Do not change this
	public Map<K, Set<K>> adj; // Do not change this

	public MGraph() {
		nodes = new BSTSet<K>();
		adj = new BSTMap<K, Set<K>>();
	}

	@Override
	public boolean addNode(K i) {
		return nodes.insert(i);
	}

	@Override
	public boolean isNode(K i) {
		return nodes.exists(i);
	}

	@Override
	public boolean addEdge(K i, K j) {
		if (!isNode(i) || !isNode(j)){
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

	@Override
	public boolean isEdge(K i, K j) {
		if (!adj.retrieve(i).first) {
			return false;
		}
		Set<K> set = adj.retrieve(i).second;
		return set.exists(j);
	}

	@Override
	public Set<K> neighb(K i) {
		if (adj.retrieve(i) == null) {
			return null;
		}
		return adj.retrieve(i).second;
	}

	@Override
	public int deg(K i) {
		if (!isNode(i)){
			return -1;
		}
		if (!adj.retrieve(i).first) {
			return 0;
		}
		return adj.retrieve(i).second.size();
	}

	@Override
	public Iterator<K> nodesIt() {
		return nodes.minIt();
	}
}

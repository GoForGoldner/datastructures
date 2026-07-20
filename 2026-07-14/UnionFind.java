class UnionFind {
	int[] parents;
	int[] rankings;
	int count;
	
	UnionFind(int n) {
		parents = new int[n];
		rankings = new int[n];
		count = n;
		
		// Every node is a parent of itself
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
	}
	
	public int find(int x) {
		while (parents[x] != x) {
			// Path compression
			parents[x] = parents[parents[x]];
			x = parents[x];
		}
		
		return x;
	}
	
	// True if successful, false is already in same tree
	public boolean merge(int x, int y) {
		int rx = find(x), ry = find(y);
		
		// Same tree already
		if (rx == ry) return false;
		
		if (rankings[rx] < rankings[ry]) {
			parents[rx] = ry;
		} else if (rankings[ry] < rankings[rx]) {
			parents[ry] = rx;
		} else {
			parent[ry] = rx;
			rankings[rx]++;
		}
		
		count--;
	}
	
	public int numOfComponents() { return count; }
	
}
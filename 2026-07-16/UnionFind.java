public class UnionFind {
	int[] parents;
	int[] rankings;
	int components;
	
	public UnionFind(int n) {
		parents = new int[n];
		rankings = new int[n];
		components = n;
		
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
	
	public boolean merge(int x, int y) {
		int rx = find(x), ry = find(y);
		
		if (rx == ry) return false; // Same tree
		
		if (rankings[rx] < rankings[ry]) {
			parents[rx] = ry;
		} else if (rankings[ry] < rankings[rx]) {
			parents[ry] = rx;
		} else {
			parents[ry] = rx;
			rankings[rx]++;
		}
		
		components--;
		return true;
	}
	
	public int getComponents() { return components; }
}
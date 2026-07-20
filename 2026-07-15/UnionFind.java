public class UnionFind {
	private int[] parents;
	private int[] rankings;
	private int count;
	
	UnionFind(int n) {
		parents = new int[n];
		rankings = new int[n];
		count = n;
		
		for (int i = 0; i < n; i++) {
			// Every node is a parent of itself
			parents[i] = i;
		}
	}
	
	public int find(int x) {
		while(parents[x] != x) {
			// Path compression
			parents[x] = parents[parents[x]];
			x = parents[x];
		}
		
		return x;
	}
	
	public boolean merge(int x, int y) {
		int rx = find(x), ry = find(y);
		
		// Same tree already
		if (rx == ry) return false;
		
		if (rankings[rx] < rankings[ry]) {
			parents[rx] = ry;
		} else if (rankings[ry] < rankings[rx]) {
			parents[ry] = rx;
		} else {
			parents[ry] = rx;
			rankings[rx]++;
		}
		
		count--;
		
		return true;
	}
	
	public int getComponents() { return count; }
}
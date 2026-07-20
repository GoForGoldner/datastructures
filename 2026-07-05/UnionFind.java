public class UnionFind {
	private int[] parents;
	private int[] rankings;
	private int count;
	
	public UnionFind(int n) {
		parents = new int[n];
		rankings = new int[n];
		count = n;
		
		for (int i = 0; i < n; i++) {
			parents[i] = i;
			rankings[i] = 1;
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
		int rx = find(x);
		int ry = find(y);
		
		// Part of the same tree
		if (rx == ry) return false;
		
		if (rankings[rx] < rankings[ry]) {
			parents[rx] = ry;
		} else if (rankings[ry] < rankings[rx]) {
			parents[ry] = rx;
		} else {
			parents[rx] = ry;
			rankings[rx]++;
		}
		
		count--; 
		return true;
	}
	
	int numberOfComponents() { return count; }
}
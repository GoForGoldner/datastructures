public class UnionFind {
  int[] parents;
  int[] rankings;
  int count;

  public UnionFind(int n) {
    parents = new int[n];
    rankings = new int[n];
    count = n;

    // Every node is a parent of itself
    for (int i = 0; i < n; i++) {
      parents[i] = i;
    }
  }

  public int find(int x) {
    while (x != parents[x]) {
      // Path compression
      parents[x] = parents[parents[x]];
      x = parents[x];
    }

    return x;
  }

  public boolean merge(int x, int y) {
    int rx = find(x), ry = find(y);

    // Same Tree
    if (rx == ry)
      return false;

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

  public int getCount() {
    return count;
  }
}

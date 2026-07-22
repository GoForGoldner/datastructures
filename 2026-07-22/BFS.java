public class BFS {
  public void bfsGrid(int[][] grid, int y, int x) {
    if (grid.length == 0 || grid[0].length == 0)
      return;

    int m = grid.length, n = grid[0].length;
    int[][] offsets = {
        { 0, 1 },
        { 0, -1 },
        { 1, 0 },
        { -1, 0 }
    };

    Deque<int[]> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[m][n];

    queue.offer(new int[] { y, x });
    visited[y][x] = true;

    while (!queue.isEmpty()) {
      int[] coords = queue.poll();

      for (int[] offset : offsets) {
        int newY = coords[0] + offset[1];
        int newX = coords[1] + offset[0];

        if (newY >= 0 && newY < m && newX >= 0 && newX < n && !visited[newY][newX]) {
          visited[newY][newX] = true;
          queue.offer(new int[] { newY, newX });
        }
      }
    }
  }

  public void bfsAdjList(List<List<Integer>> adjList, int n, int k) {
    boolean[] visited = new boolean[n];
    Deque<Integer> queue = new ArrayDeque<>();

    queue.offer(k);
    visited[k] = true;

    while (!queue.isEmpty()) {
      int node = queue.poll();

      for (int target : adjList.get(node)) {
        if (!visited[target]) {
          visited[target] = true;
          queue.offer(target);
        }
      }
    }
  }
}

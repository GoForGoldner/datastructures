public class Dijkstra {
  public int[] dijkstra(List<List<int[]>> adjList, int n, int k) {
    int[] output = new int[n];
    Arrays.fill(output, Integer.MAX_VALUE);
    output[k] = 0;

    // Min heap of [Distance, Target]
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
    pq.offer(new int[] { 0, k });

    while (!pq.isEmpty()) {
      int[] p = pq.poll();
      int distance = p[0], node = p[1];

      // Skip stale entries
      if (output[node] < distance)
        continue;

      for (int[] edge : adjList.get(node)) {
        int w = edge[0], v = edge[1];

        if (output[node] + w < output[v]) {
          output[v] = output[node] + w;
          pq.offer(new int[] { output[v], v });
        }
      }
    }

    return output;
  }
}

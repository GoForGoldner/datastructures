import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class NetworkDelayTime {
  class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
      List<List<int[]>> adjList = buildAdjacencyList(times, n, k);

      int[] output = dijkstra(adjList, n, k - 1);

      int m = Arrays.stream(output).max().getAsInt();
      return m == Integer.MAX_VALUE ? -1 : m;
    }

    private List<List<int[]>> buildAdjacencyList(int[][] times, int n, int k) {
      List<List<int[]>> adjList = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        adjList.add(new ArrayList<>());
      }

      for (int[] t : times) {
        int source = t[0] - 1, target = t[1] - 1, time = t[2];
        adjList.get(source).add(new int[] { time, target });
      }

      return adjList;
    }

    private int[] dijkstra(List<List<int[]>> adjList, int n, int k) {
      int[] output = new int[n];
      Arrays.fill(output, Integer.MAX_VALUE);
      output[k] = 0;

      // Min heap of distances
      // [distance, target]
      PriorityQueue<int[]> pq = new PriorityQueue<>(
          (a, b) -> a[0] - b[0]);
      pq.offer(new int[] { 0, k });

      while (!pq.isEmpty()) {
        int[] edge = pq.poll();
        int distance = edge[0], node = edge[1];

        // Prevent stale entries
        if (output[node] < distance)
          continue;

        for (int[] e : adjList.get(node)) {
          int w = e[0], v = e[1];
          if (output[node] + w < output[v]) {
            output[v] = output[node] + w;
            pq.offer(new int[] { output[v], v });
          }
        }
      }

      return output;
    }
  }
}

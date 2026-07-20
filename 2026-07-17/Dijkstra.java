public class Dijkstra {
	public int[] dijkstra(List<List<int[]>> adjList, int n, int k) {
		int[] output = new int[n];
		Arrays.fill(output, Integer.MAX_VALUE);
		output[k] = 0;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(a, b) -> a[0] - b[0]
		);
		pq.offer(new int[]{ 0, k });
		
		while(!pq.isEmpty()) {
			int[] edge = pq.poll();
			int distance = edge[0], node = edge[1];
			
			// Skip stale entries
			if (output[node] < distance) continue;
			
			for (int[] t : adjList.get(node)) {
				int w = t[0], v = t[1];
				if (output[node] + w < output[v]) {
					output[v] = output[node] + w;
					pq.offer(new int[]{ output[v], v });
				}
			}
		}
			
		return output;
	}
}
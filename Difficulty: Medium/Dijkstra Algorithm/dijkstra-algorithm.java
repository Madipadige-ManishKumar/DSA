import java.util.*;

class Solution {

    public int[] dijkstra(int V, int[][] edges, int src) {

        // Step 1: Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

    
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[]{0, src}); 

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();
            int currDist = curr[0];
            int u = curr[1];

            // Skip outdated entries
            if (currDist > dist[u]) continue;

            // Step 3: Relax neighbors only
            for (int[] nei : adj.get(u)) {
                int v = nei[0];
                int w = nei[1];

                if (currDist + w < dist[v]) {
                    dist[v] = currDist + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        return dist;
    }
}

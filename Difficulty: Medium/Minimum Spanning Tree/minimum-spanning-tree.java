class Solution {
    public int spanningTree(int V, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new int[]{v, wt});
            adj.get(v).add(new int[]{u, wt});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] vis = new int[V];
        pq.add(new int[]{0, 0}); // {weight, node}

        int sum = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int wt = curr[0];
            int node = curr[1];

            if (vis[node] == 1) continue;

            vis[node] = 1;
            sum += wt;

            for (int[] nei : adj.get(node)) {
                int next = nei[0];
                int edgeWt = nei[1];
                if (vis[next] == 0) {
                    pq.add(new int[]{edgeWt, next});
                }
            }
        }

        return sum;
    }
}

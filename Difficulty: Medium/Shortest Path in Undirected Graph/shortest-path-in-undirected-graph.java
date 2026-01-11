class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
                }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neigh : adj.get(node)) {
                if (dist[neigh] > dist[node] + 1) {
                    dist[neigh] = dist[node] + 1;
                    q.offer(neigh);
                }
            }
        }
        for(int i=0;i<dist.length;i++)
        {
            if(dist[i]==Integer.MAX_VALUE)
            dist[i]=-1;
        }

        return dist;
    }
}

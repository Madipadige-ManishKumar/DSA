import java.util.*;

class Solution {

    public ArrayList<Integer> bfs(int start, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> component = new ArrayList<>();

        queue.add(start);
        vis[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            component.add(node);

            for (int neighbor : adj.get(node)) {
                if (vis[neighbor] == 0) {
                    queue.add(neighbor);
                    vis[neighbor] = 1;
                }
            }
        }
        return component;
    }

    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        int[] vis = new int[V];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                res.add(bfs(i, adj, vis));
            }
        }
        return res;
    }
}

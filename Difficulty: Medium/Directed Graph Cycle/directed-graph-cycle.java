class Solution {
    public boolean isCyclic(int V, int[][] edges) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // build graph
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int cnt = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            cnt++;

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) queue.offer(it);
            }
        }

        return cnt != V; // true → cycle exists
    }
}

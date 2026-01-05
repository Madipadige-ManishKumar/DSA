class Solution {

    public void dfs(ArrayList<ArrayList<Integer>> edges, int[] vis, int i, Stack<Integer> stack) {
        vis[i] = 1;

        for (Integer it : edges.get(i)) {
            if (vis[it] == 0) {
                dfs(edges, vis, it, stack);
            }
        }
        stack.push(i);
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {

        int[] vis = new int[V];
        Stack<Integer> stack = new Stack<>();

        ArrayList<ArrayList<Integer>> myedges = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            myedges.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            myedges.get(edges[i][0]).add(edges[i][1]);
        }

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(myedges, vis, i, stack);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }
}

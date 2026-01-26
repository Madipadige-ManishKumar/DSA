// Class to manage Disjoint Set Union
class DSU {
    int[] parent;
    int[] rank;

    // Initialize DSU with n nodes
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        // Initially, every node is its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    // Find with path compression
    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union by rank
    void unite(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) return;

        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}
class Solution {
    public int makeConnected(int n, int[][] edges) {
        if(edges.length <n-1) return -1;

        DSU dsu = new DSU(n);

        for(int []edge:edges)
        {
            dsu.unite(edge[0],edge[1]);
        }

        Set<Integer> components = new HashSet();
        for(int i =0;i<n;i++)
        {
            components.add(dsu.find(i));
        }

        return components.size()-1;

    }
}
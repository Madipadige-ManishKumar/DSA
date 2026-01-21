// User function Template for Java

class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int dist[] = new int[V];
        for(int i=0;i<V;i++)
        {
            dist[i]=100000000;
        }
        dist[src]=0;
        for(int i=0;i<V-1;i++)
        {
            for(int []curr:edges)
            {
                int u = curr[0];
                int v = curr[1];
                int wt = curr[2];
                if(dist[u] != 100000000  && dist[u]+wt <dist[v])
                {
                    dist[v]=dist[u]+wt;
                }
            }
        }
        for(int[] it:edges)
        {
            int u =it[0];
            int v = it[1];
            int wt = it[2];
             if(dist[u] != 100000000  && dist[u]+wt <dist[v])
                {
                    return new int[]{-1};
                }
        }
        return dist;
    }
}

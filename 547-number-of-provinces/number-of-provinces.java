class Solution {
    public void bfs(int start , int[][] adj , int []vis)
    {
        ArrayList<Integer>queue = new ArrayList<>();
        queue.add(start);
        vis[start]=1;
        while(!queue.isEmpty())
        {
            int node = queue.remove(0);
            int adjnodes []  = adj[node];
            for(int i=0;i<adjnodes.length;i++)
            {
                if(adjnodes[i]==1 && vis[i]!=1){
                    queue.add(i);
                    vis[i]=1;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        // input is [[1,1,0],[1,1,0],[0,0,1]]
        int [] vis = new int[isConnected.length];
        int count=0;
        for(int i =0;i<vis.length;i++)
        {
            vis[i]=0;
        }
        for(int i=0;i<vis.length;i++)
        {
            if(vis[i]==0)
            {
                bfs(i,isConnected,vis);
                count++;
            }
        }
        return count;
    }
}
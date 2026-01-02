class Solution {
    public boolean dfs(int node, int col, int[] color, int [][] adj)
    {
        color[node] = col;
        for(int item:adj[node])
        {
            if(color[item] == -1){
                // System.out.println("node :"+node+" Item "+item);
                if(dfs(item,1-col,color,adj) ==false) return false;   
            }
            else if(color[item] == col )
                return false;
        }
        return true;
    } 

    /*

        [ [1 2 3],[0,2],[0,1,3],[0,2]]
                0   1       2      3
        color [ 0 1 -1 -1 -1]

    */
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int [] color = new int[V+1];

        for(int i=0;i<V;i++)
        color[i]=-1;

        for(int i =0;i<V+1;i++)
        {
            if(color[i] == -1){
                if(dfs(i,0,color,graph)==false) return false;
            }
        }
        return true;
    }
}
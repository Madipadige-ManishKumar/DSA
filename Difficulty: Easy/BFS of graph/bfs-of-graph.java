class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList<Integer> visited = new ArrayList<Integer>();
        ArrayList<Integer> queue = new ArrayList<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(adj.size()<1)
        return new ArrayList<Integer>();
        queue.add(0);
        visited.add(0);
        while (!queue.isEmpty())
        {
            
            int node = queue.remove(0);
            ArrayList <Integer> nbhs = new ArrayList<Integer>(adj.get(node));
            for(int i=0;i<nbhs.size();i++)
            {
                if(visited.contains(nbhs.get(i)))
                    continue;
                else
                    queue.add(nbhs.get(i));
                    visited.add(nbhs.get(i));
            }
            // System.out.println(res);
            res.add(node);
        }
        
        
        return res;
    }
}

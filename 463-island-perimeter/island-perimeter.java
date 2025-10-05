class Solution {
    public int islandPerimeter(int[][] grid) {
        int s=0;
        int i,j;
        for(i=0;i<grid.length;i++)
        {
            for(j=0;j<grid[i].length;j++)
            {
                
                if(grid[i][j]==1)
                {
                    s+=4;
                    if(j-1>=0)
                    {
                        
                        if(grid[i][j-1]==1)
                        s--;
                    }
                    if(j+1<grid[i].length)
                    {
                        if(grid[i][j+1]==1)
                        s--;
                    }
                    if(i-1>=0)
                    {
                        if(grid[i-1][j]==1)
                        s--;
                    }
                    if(i+1<grid.length)
                    {
                        if(grid[i+1][j]==1)
                        s--;
                    }
                }
            }
        }
        return s;
    }
}
class Solution {
    public void dfs(char[][]board ,int [][] vis, int r,int c , int[][] dir)
    {
        vis[r][c]=1;
        int m = board.length;
        int n = board[0].length;
        for(int[] d: dir)
        {
            int nr,nc;
            nr = r+d[0];
            nc= c+d[1];
            if(nr >=0 && nc>=0 && nr<m && nc<n && vis[nr][nc]==0 && board[nr][nc]=='O')
            {
                dfs(board,vis,nr,nc,dir);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int [][]dir ={ {0,-1},{-1,0},{0,1},{1,0} };
        // System.out.println(dir[0].length);
        int [][]vis = new int [m][n];
        for(int i=0;i<m;i++)
        {
            if(board[i][0] == 'O')
            {
                dfs(board,vis,i,0,dir);
            }
            if(board[i][n-1]== 'O')
            {
                dfs(board,vis,i,n-1,dir);
            }
        }
        for(int i=0;i<n;i++)
        {

            if(board[0][i] == 'O')
            {
                dfs(board,vis,0,i,dir);
            }
            if(board[m-1][i]== 'O')
            {
                dfs(board,vis,m-1,i,dir);
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(vis[i][j]==0 && board[i][j]=='O')
                board[i][j]='X';
            }
        }
        
    }
}
class Solution {
    public boolean find(char [][] board , String s , int index, int i,int j)
    {
        int [][] direction = { {1,0},{-1,0},{0,1},{0,-1}  };
        if(index == s.length() )
        return true;
        if(i<0||j<0||i>=board.length||j>=board[i].length||board[i][j]=='$')
        return false;
        if (s.charAt(index)!= board[i][j])
        return false;
        char temp = board[i][j];
        board[i][j]='$';
        for(int k =0;k<direction.length;k++)
        {
            int new_i= i+direction[k][0];
            int new_j= j+direction[k][1];
            if(this.find(board,s,index+1,new_i,new_j))
            return true;
        }
        board[i][j]=temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]==word.charAt(0)&&this.find(board,word,0,i,j))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
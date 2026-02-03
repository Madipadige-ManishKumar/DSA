class Solution {
    int find_seq(int []heights,int index,int []dp)
    {
        if(index ==0)
        return 0;
        
        if(dp[index]!=-1)
            return dp[index];
        
        int left,right;
        
        right = Integer.MAX_VALUE;
        
        left = find_seq(heights,index-1,dp)+Math.abs(heights[index-1]-heights[index]);
        
        if(index>1)
        
        right = find_seq(heights,index-2,dp)+Math.abs(heights[index-2]-heights[index]);
        
        dp[index]=Math.min(left,right);
        return dp[index];
    }
    
    int minCost(int[] height) {
        // code here
        int dp[] = new int[height.length];
        for(int i=0;i<dp.length;i++)
        dp[i]=-1;
        return find_seq(height,height.length-1,dp);
    }
}
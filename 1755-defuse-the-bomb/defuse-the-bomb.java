class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int [] res = new int[n];
        int cursum=0;
        int x,y;
        if(k == 0)
        return res;
        if(n == 1)
        return code;
        else if(k<0)
        {
            y=n-1;
            x = y+k+1;
           
        }
        else
        {
            x = 1;
            y = x+k-1;

        }
         for(int i=x;i<=y;i++)
            {
                cursum +=code[i];
            }
            
            for(int i=0;i<n;i++)
            {
                System.out.println(cursum);
                res[i]=cursum;
                cursum-=code[x];
                x=(x+1)%n;
                y = (y+1)%n;
                cursum+=code[y];
            }
        
        return res;
    }
}
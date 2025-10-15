class Solution {
    public int findMin(int num) {
        // code here
        int  n = num;
        int count =0;
            if(n>=10)    
            {
                count += n/10;
                n=n%10;
            }
            if(n>=5)
            {
                count+=n/5;
                n=n%5;
            }
            if( n>=2)
            {
                count+=n/2;
                n=n%2;
            }
            if( n>=1)
            {
                count+=n/1;
                n=n%1;
            }
        return count;
        
    }
}

class Solution {
    public int no_of_ones(int n)
    {
        int count=0;
        while(n>0)
        {
            n = n&(n-1);
            count++;
        }
        return count;
    }
    public boolean is_prime(int n)
    {
        if(n<=1) return false;
        for(int i=2;i<n;i++)
        {
            if(n%i ==0) return false;
        }
        return true;
    }
    public int countPrimeSetBits(int left, int right) {

        int curr = left;
        int res=0;
        while(curr<=right)
        {
            int count = no_of_ones(curr);
            if(is_prime(count))
            res++;

            curr++;
        }
        return res;

    }
}
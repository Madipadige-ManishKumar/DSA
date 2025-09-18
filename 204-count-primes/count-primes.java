class Solution {
    public int countPrimes(int n) {
        int [] prime = new int[n+1];
        for(int i=2;i*i<=n;i++)
        {
            if(prime[i]==0){
                for(int j= i*i;j<=n;j+=i)
                {
                    prime[j]=1;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++)
        {
            if(prime[i]==0)
            count++;
        }
        return count;

    }
}
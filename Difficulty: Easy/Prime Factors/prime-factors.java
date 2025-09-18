class Solution {
    public static int [] is_prime(int n)
    {
        int [] arr = new int[n+1];
        for(int i=2;i*i<=n;i++)
        {
            if(arr[i]==0){
                for(int j =(i*i);j<=n;j+=i)
            {
                
                arr[j]=1;
            }
            }
        }
        return arr;
    }
    public static ArrayList<Integer> primeFac(int n) {
        // code here
        int [] arr = Solution.is_prime(n);
        // for(int i=0;i<arr.length;i++)
        // {
        //     System.out.println(i+"  "+arr[i]);
        // }
        ArrayList res = new ArrayList<Integer>();
        for(int i=2;i<=n;i++)
        {
            if(n%i ==0)
            {
                if(arr[i]==0)
                {
                    res.add(i);
                }
            }
        }
        return res;
        
    }
}
        



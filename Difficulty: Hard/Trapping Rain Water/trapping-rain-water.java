class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        if(n ==0)
        return 0;
        int maxl[] = new int[n];
        int maxr[] = new int[n];
        int ele = arr[0];
        maxl[0]=ele;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>ele){
                ele = arr[i];
            }
            maxl[i]=ele;
        }
        ele = arr[n-1];
        maxr[n-1]=ele;
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>ele){
                ele = arr[i];
            }
            maxr[i]=ele;
        }
        int water=0;
         for (int i = 0; i < n; i++) {
            water += Math.min(maxl[i], maxr[i]) - arr[i];
        }
        return water;
    }
}

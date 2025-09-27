class Solution {
    public int maxScore(int[] nums, int k) {
        int l,r;
        l=nums.length-k;
        r=nums.length-1;
        int sum =0;
        for(int i=l;i<=r;i++)
        sum+=nums[i];
        int max = sum;
        while(l!=0)
        {
            sum-=nums[l];
            l++;
            l=l%nums.length;
            r++;
            r=r%nums.length;
            sum+=nums[r];
            if(sum>max)
            max=sum;
        }
        return max;
    }
}
class Solution {
    public int longestOnes(int[] nums, int k) {
        int l,r,maxlen=0;
        l=r=0;
        int zeros=0;
        while(r<nums.length)
        {
            if(nums[r]==0) zeros++;
            if(zeros>k)
            {
                if(nums[l]==0)     //   1 1 1 0 0 0 1 1 1 1 0
                zeros--;
                l++;
            }
            if (zeros<=k)
            {
                int len =  r-l+1;
                maxlen=Math.max(maxlen,len);
            }
            r++;
        }
        return maxlen;
    }
}
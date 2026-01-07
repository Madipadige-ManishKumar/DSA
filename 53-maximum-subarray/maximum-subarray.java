class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0,max=0,i,pt=0,f=0;
        if(nums.length==1)
        {
            return nums[0];
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                pt++;
            }
        }
        if(pt==nums.length)
        {
            max=nums[0];
            for(i=0;i<nums.length;i++)
            {
                if(max<nums[i])
                max=nums[i];
            }
            return max;
        }
        
        for(i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(max<sum)
            {
                max=sum;
            }
            if(sum<0)
            {sum=0;}
        }
        return max;
    }
}
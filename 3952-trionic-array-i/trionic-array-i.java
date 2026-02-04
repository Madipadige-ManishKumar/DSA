class Solution {
    public boolean isTrionic(int[] nums) {


        if(nums[0]>=nums[1])
        return false;
        boolean inc = true;
        int count =1;
        for(int i =1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1]) return false;
            if(nums[i]<nums[i-1] && inc)
            {
                inc = false;
                count++;   
            }
            else if(nums[i]>nums[i-1] && !inc)
            {
                inc = true;
                count++;
            }
        }
        if(inc && count ==3)
        return true;
        return false;
    }
}
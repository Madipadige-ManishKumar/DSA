class Solution {
    public int thirdMax(int[] nums) {
        int l1,l2,l3,f1=0;
        l1=l2=l3=Integer.MIN_VALUE;
        int i;
        // if(nums.length>=3){
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==-2147483648)
            {
                f1=1;
            }
            if(nums[i]>l1)
            {
                l3=l2;
                l2=l1;
                l1=nums[i];
            }
            if(nums[i]>l2 && nums[i]<l1)
            {
                l3=l2;
                l2=nums[i];
            }
            if(nums[i]>l3 &&(nums[i]<l1&&nums[i]<l2))
            {
                l3=nums[i];
            }
        }

    // }
    if(l2==Integer.MIN_VALUE)
    return l1;
    if(l3==Integer.MIN_VALUE && f1==0)
    {
        return l1;
    }
        // else if(nums.length==1)
        // return nums[0];
        // else if(nums.length==2)
        // {
        //     if(nums[0]>nums[1])
        //     return nums[0];
        //     else
        //     return nums[1];
        // }
        return l3;
    }
}
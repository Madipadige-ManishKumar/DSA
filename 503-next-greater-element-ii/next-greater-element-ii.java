class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int res[] = new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            int  j= i+1;
            j=(j%nums.length);
            int flag =0;
            while (j!=i)
            {
                if(nums[i]<nums[j]){
                res[i]=nums[j];
                flag =1;
                break;
                }

                j++;
                j=(j%nums.length);
            }
            if(flag==0)
            res[i]=-1;
        }
        return res;
    }
}
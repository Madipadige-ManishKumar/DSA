class Solution {
    public int firstMissingPositive(int[] nums) {
     int max = Integer.MIN_VALUE;
     if(nums.length ==0)
     return 1;
    HashMap<Integer,Integer> map = new HashMap<>();
     for(int i=0;i<nums.length;i++)   
     {
        max = Math.max(nums[i],max);
        if(nums[i]>0)
        map.put(nums[i],1);
     }
     if(max<=0) return 1;
     for(int i=1;i<=max;i++)
     {
        if(map.get(i) == null)
        {
            return i;
        }
     }
     return max+1;
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>  map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.containsKey(nums[i]))
            map.put(nums[i],1);
            else
            {
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for(int it:map.keySet())
        {
            if(map.get(it)>(nums.length/2))
            return it;
        }
        return -1;
    }
}
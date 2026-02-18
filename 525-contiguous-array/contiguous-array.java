class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i] == 0)
            nums[i]=-1;
        }
        HashMap<Integer,Integer>  map = new HashMap<>(); // This will add the number with the index
        int sum=0;
        int max=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(map.containsKey(sum))
            {
                int pre = map.get(sum);
                max = Math.max((i-pre),max);
            }
            else
            map.put(sum,i);

            if(sum == 0)
            max=Math.max(i+1,max);
        }

        return max;
    }
}
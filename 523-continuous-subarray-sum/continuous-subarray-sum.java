class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int run_sum =0;
        for(int i=0;i<nums.length;i++)
        {   

            run_sum +=nums[i];
            if(k!=0)
            {
                run_sum=run_sum%k;
            }

            if(map.get(run_sum) == null)
            {
                map.put(run_sum,i);
            }
            else{

                int prevIndex = map.get(run_sum);
                
                if (i - prevIndex > 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
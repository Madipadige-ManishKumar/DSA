class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            
            int currsum = 0;
            int count = 0;
            int j = i;

            
            while (count < n) {
                currsum += nums[j];
                maxsum = Math.max(maxsum, currsum);

                
                if (currsum < 0) break;

                j++;
                if (j == n) j = 0;  
                count++;
            }
        }

        return maxsum;
    }
}
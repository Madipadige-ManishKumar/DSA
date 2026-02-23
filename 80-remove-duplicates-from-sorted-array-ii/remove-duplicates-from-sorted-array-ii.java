class Solution {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 0) return 0;

        int j = 1;
        int count = 1;
        int can = nums[0];
        int n = nums.length;

        for(int i = 1; i < n; i++) {
            if(nums[i] == can) {
                count++;
                if(count <= 2) {
                    nums[j] = nums[i];
                    j++;
                }
            } else {
                can = nums[i];
                count = 1;
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
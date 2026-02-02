class Solution {

    public int find_seq(int index, int[] nums, Integer[] memo) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        // Choice 1: Take this house
        int take = nums[index] + find_seq(index + 2, nums, memo);

        // Choice 2: Skip this house
        int skip = find_seq(index + 1, nums, memo);

        memo[index] = Math.max(take, skip);
        return memo[index];
    }

    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return find_seq(0, nums, memo);
    }
}

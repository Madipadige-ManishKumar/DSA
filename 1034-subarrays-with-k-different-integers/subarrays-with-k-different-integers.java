import java.util.HashMap;

class Solution {
    private int find_subarrays(int[] nums, int k) {
        int l = 0, r = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            // Add right element
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            // Shrink window if distinct count > k
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);
                l++;
            }

            // Add number of subarrays ending at r
            count += (r - l + 1);
            r++;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return find_subarrays(nums, k) - find_subarrays(nums, k - 1);
    }
}
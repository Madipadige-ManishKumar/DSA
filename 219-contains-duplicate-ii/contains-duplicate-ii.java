class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int len = i - map.get(nums[i]);
                if (len <= k) return true;
            }
            // update the last seen index
            map.put(nums[i], i);
        }
        
        return false;
    }
}

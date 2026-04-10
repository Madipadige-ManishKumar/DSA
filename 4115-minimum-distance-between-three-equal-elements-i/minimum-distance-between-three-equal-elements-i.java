class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new int[]{i, -1});
            } else {
                int[] arr = map.get(nums[i]);

                if (arr[1] == -1) {
                    arr[1] = i; 
                } else {
                    
                    int first = arr[0];
                    int second = arr[1];
                    int third = i;

                    int cur = Math.abs(first-second)+Math.abs(second-third)+Math.abs(third-first); 
                    min = Math.min(min, cur);

                    
                    arr[0] = second;
                    arr[1] = third;
                }
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
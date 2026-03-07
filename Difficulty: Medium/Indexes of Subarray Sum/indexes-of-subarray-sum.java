class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int left = 0;
        int currentSum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        
        for (int right = 0; right < arr.length; right++) {
            // 1. Add current element to sum
            currentSum += arr[right];
            
            // 2. Shrink window from the left while sum is too large
            while (currentSum > target && left < right) {
                currentSum -= arr[left];
                left++;
            }
            
            
            if (currentSum == target) {
                res.add(left + 1); // 1-based indexing
                res.add(right + 1);
                return res;
            }
        }
        
        res.add(-1);
        return res;
    }
}
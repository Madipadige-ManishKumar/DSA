import java.util.*;

class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= nums[i]) {
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(nums[i]);
        }

        // Convert array to ArrayList
        ArrayList<Integer> res = new ArrayList<>(n);
        for (int val : ans) {
            res.add(val);
        }
        return res;
    }
}
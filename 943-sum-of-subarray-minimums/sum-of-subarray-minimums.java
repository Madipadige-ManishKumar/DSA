import java.util.*;

public class Solution {
    public ArrayList<Integer> findNse(int[] nums) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        // scan right -> left
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            res.add(st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        Collections.reverse(res); // reverse to get correct order
        return res;
    }

    public ArrayList<Integer> findPse(int[] nums) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        // scan left -> right
        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            res.add(st.isEmpty() ? -1 : st.peek());
            st.push(i);
        }
        return res;
    }

    public int sumSubarrayMins(int[] arr) {
        ArrayList<Integer> nse = findNse(arr);
        ArrayList<Integer> pse = findPse(arr);

        long total = 0;
        int mod = (int)1e9 + 7;
        for (int i = 0; i < arr.length; i++) {
            int left = i - pse.get(i);
            int right = (nse.get(i) == -1 ? arr.length : nse.get(i)) - i;
            long contrib = ((long) left * right) % mod;
            contrib = (contrib * arr[i]) % mod;
            total = (total + contrib) % mod;
        }
        return (int) total;
    }
}

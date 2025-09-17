import java.util.*;

class Solution {
    ArrayList<Integer> twoOddNum(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                res.add(entry.getKey());
            }
        }
        Collections.reverse(res);
        return res;
    }
}

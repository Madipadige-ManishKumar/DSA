import java.util.HashMap;

class Solution {
    public int longestKSubstr(String s, int k) {
        int l = 0, r = 0, maxlen = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // shrink window if more than k unique
            while (map.size() > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                l++;
            }

            // check if exactly k unique
            if (map.size() == k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }
            r++;
        }
        return maxlen;
    }
}

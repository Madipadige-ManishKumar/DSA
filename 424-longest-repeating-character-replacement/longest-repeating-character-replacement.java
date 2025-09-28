import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, maxlen = 0, maxCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // track max frequency in current window
            maxCount = Math.max(maxCount, map.get(ch));

            // if window length - maxCount > k, shrink from left
            while ((r - l + 1) - maxCount > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
        }

        return maxlen;
    }
}

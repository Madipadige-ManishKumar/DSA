class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
         int l = 0, maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            if (map.containsKey(ch)) {
                l = Math.max(l, map.get(ch) + 1);
            }

            map.put(ch, r);

            int len = r - l + 1;
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
class Solution {
    public String minWindow(String s, String t) {
             if (s.length() == 0 || t.length() == 0) return "";

        // Step 1: Build frequency map for t
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Sliding window setup
        HashMap<Character, Integer> windowMap = new HashMap<>();
        int l = 0, r = 0;
        int formed = 0; // Number of chars matched with required frequency
        int required = tMap.size();

        // Track the minimum window
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            // If character frequency matches tMap, increment 'formed'
            if (tMap.containsKey(c) && windowMap.get(c).intValue() == tMap.get(c).intValue()) {
                formed++;
            }

            // Try to shrink the window from the left
            while (l <= r && formed == required) {
                c = s.charAt(l);

                // Update minimum window
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    start = l;
                }

                // Remove the left char from window
                windowMap.put(c, windowMap.get(c) - 1);
                if (tMap.containsKey(c) && windowMap.get(c).intValue() < tMap.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

}
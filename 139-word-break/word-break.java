import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict); // O(1) lookup
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // empty string is always valid

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // no need to check further
                }
            }
        }
        return dp[s.length()];
    }
}

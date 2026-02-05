class Solution {
    public int f(int day, int last, int[][] mat, int[][] dp) {
        if (day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last)
                    maxi = Math.max(maxi, mat[0][i]);
            }
            return maxi;
        }

        if (dp[day][last] != -1) 
            return dp[day][last];

        int maxi = 0;

        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int activity = mat[day][i] + f(day - 1, i, mat, dp);
                maxi = Math.max(maxi, activity);
            }
        }

        return dp[day][last] = maxi;
    }

    public int maximumPoints(int mat[][]) {
        int n = mat.length;
        int[][] dp = new int[n][4];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }

        return f(n - 1, 3, mat, dp);
    }
}

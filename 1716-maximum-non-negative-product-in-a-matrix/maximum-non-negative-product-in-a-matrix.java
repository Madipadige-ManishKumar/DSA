class Solution {

    public void func(int r, int c, int n, int m,
                     int[][] grid, long[] total_cost, long cost) {

        if (r >= n || c >= m) return;

        cost *= grid[r][c];

        if (cost == 0 && total_cost[0] >= 0) return;

        if (r == n - 1 && c == m - 1) {
            total_cost[0] = Math.max(total_cost[0], cost);
            return;
        }

        func(r + 1, c, n, m, grid, total_cost, cost);
        func(r, c + 1, n, m, grid, total_cost, cost);
    }

    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long MOD = 1_000_000_007L;

        
        long[] total_cost = {Long.MIN_VALUE};

        func(0, 0, n, m, grid, total_cost, 1);

        if (total_cost[0] < 0) return -1;

        return (int)(total_cost[0] % MOD);
    }
}
class Solution {
 public void dfs(char[][] board, int[][] vis, int[][] dir,
                int r, int c, int m, int n) {

    vis[r][c] = 1;

    for (int[] d : dir) {
        int nr = r + d[0];
        int nc = c + d[1];

        if (nr >= 0 && nc >= 0 && nr < m && nc < n &&
            board[nr][nc] == 'X' &&
            vis[nr][nc] == 0) {

            dfs(board, vis, dir, nr, nc, m, n);
        }
    }
}

   public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] hor = {{0, 1}, {0, -1}};
        int[][] ver = {{1, 0}, {-1, 0}};

        int count = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if (vis[r][c] == 1) continue;

            vis[r][c] = 1;

            // decide direction BEFORE DFS
            if (c + 1 < n && board[r][c + 1] == 'X') {
                dfs(board, vis, hor, r, c, m, n);
            } else if (r + 1 < m && board[r + 1][c] == 'X') {
                dfs(board, vis, ver, r, c, m, n);
            }

            count++;
        }

        return count;
    }
}
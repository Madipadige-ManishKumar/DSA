import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int vis [][] = new int[n][n];
        if (n == 1 && grid[0][0]==0) return 1;
        
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        vis[0][0]=1;

        int[][] dir = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            int dis = node[2];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];
                int n_dis = dis + 1;

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0 && vis[nr][nc]==0) {
                    vis[nr][nc]=1;
                    if (nr == n - 1 && nc == n - 1) {
                        return n_dis;
                    }
                    queue.offer(new int[]{nr, nc, n_dis});
                }
            }
        }
        return -1;
    }
}

import java.util.*;

class Solution {
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    private void solve(int col, List<List<String>> res, char[][] board,
                       int[] left, int[] upper, int[] lower, int n) {
        if (col == n) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (left[row] == 0 && upper[row + col] == 0 && lower[(n - 1) + (col - row)] == 0) {
                board[row][col] = 'Q';
                left[row] = 1;
                upper[row + col] = 1;
                lower[(n - 1) + (col - row)] = 1;

                solve(col + 1, res, board, left, upper, lower, n);

                board[row][col] = '.';
                left[row] = 0;
                upper[row + col] = 0;
                lower[(n - 1) + (col - row)] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> res = new ArrayList<>();
        int[] left = new int[n];
        int[] lower = new int[2 * n - 1];
        int[] upper = new int[2 * n - 1];

        solve(0, res, board, left, upper, lower, n);
        return res;
    }
}

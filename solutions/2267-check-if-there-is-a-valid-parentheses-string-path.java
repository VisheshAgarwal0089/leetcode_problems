class Solution {
    public boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        if (grid[0][0] == ')' || grid[n - 1][m - 1] == '(') {
            return false;
        }

        int[][][] dp = new int[n][m][201];

        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }

        return solve(grid, dp, 0, 0, 0, n, m);
    }

    private boolean solve(char[][] grid, int[][][] dp,
                          int i, int j, int count,
                          int n, int m) {

        count += (grid[i][j] == '(') ? 1 : -1;

        if (count < 0) {
            return false;
        }

        if (dp[i][j][count] != -1) {
            return dp[i][j][count] == 1;
        }

        if (i == n - 1 && j == m - 1) {
            dp[i][j][count] = (count == 0) ? 1 : 0;
            return count == 0;
        }

        if (i + 1 < n) {
            if (solve(grid, dp, i + 1, j, count, n, m)) {
                dp[i][j][count] = 1;
                return true;
            }
        }

        if (j + 1 < m) {
            if (solve(grid, dp, i, j + 1, count, n, m)) {
                dp[i][j][count] = 1;
                return true;
            }
        }

        dp[i][j][count] = 0;
        return false;
    }
}
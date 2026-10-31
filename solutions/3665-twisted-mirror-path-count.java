class Solution {
    int n;
    int m;
    int left = 0;
    int up = 1;
    int mod = 1000000007;

    public int uniquePaths(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int dp[][][] = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(grid, 0, 0, left, dp);
    }

    private int solve(int grid[][], int i, int j, int camefrom, int dp[][][]) {
        if (i >= n || j >= m) {
            return 0;
        }
        if (dp[i][j][camefrom] != -1) {
            return dp[i][j][camefrom];
        }
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (grid[i][j] == 1) {
            if (camefrom == left) {
                return dp[i][j][camefrom] = solve(grid, i + 1, j, up, dp);
            } else {
                return dp[i][j][camefrom] = solve(grid, i, j + 1, left, dp);
            }
        }
        long totalpath = 0;
        totalpath += solve(grid, i, j + 1, left, dp) % mod;
        totalpath += solve(grid, i + 1, j, up, dp) % mod;
        return dp[i][j][camefrom] = (int)(totalpath % mod);
    }
}
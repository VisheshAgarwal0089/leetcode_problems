class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < rowShift[i]; k++) {
                int first = grid[i][0];
                for (int j = 0; j < n - 1; j++) {
                    grid[i][j] = grid[i][j + 1];
                }
                grid[i][n - 1] = first;
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < colShift[j]; k++) {
                int first = grid[0][j];
                for (int i = 0; i < n - 1; i++) {
                    grid[i][j] = grid[i + 1][j];
                }
                grid[n - 1][j] = first;
            }
        }
        return grid;
    }
}
// class Solution {
//     public int solve(int arr[][],int dp[][],int m,int n){
//         if (m < 0 || n < 0) {
//             return 1;
//         }
//         if(m==0&&n==0){
//             return arr[0][0];
//         }
//         if(dp[m][n]!=-1){
//             return dp[m][n];
//         }
//         return dp[m][n]=Math.min(arr[m][n]^solve(arr,dp,m-1,n),arr[m][n]^solve(arr,dp,m,n-1));
//     }
//     public int minCost(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
//         int dp[][]=new int[m][n];
//         for(int i=0;i<m;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         // Arrays.fill()
//         return solve(grid,dp,m-1,n-1);
//     }
// }

class Solution {

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] dp = new boolean[n][1024];
        boolean[] next = new boolean[1024];

        dp[0][grid[0][0]] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int value = grid[i][j];
                Arrays.fill(next, false);

                for (int k = 0; k < 1024; k++) {
                    if (dp[j][k] || (j > 0 && dp[j - 1][k])) {
                        next[k ^ value] = true;
                    }
                }

                System.arraycopy(next, 0, dp[j], 0, 1024);
            }
        }

        for (int k = 0; k < 1024; k++) {
            if (dp[n - 1][k]) {
                return k;
            }
        }

        return -1;
    }
}
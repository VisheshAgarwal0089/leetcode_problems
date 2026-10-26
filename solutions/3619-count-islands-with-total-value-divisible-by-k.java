class Solution {
    int m,n;
    long dfs(int grid[][],int r,int c){
        if(r>=m||r<0||c>=n||c<0){
            return 0;
        }
        if(grid[r][c]==0){
            return 0;
        }
        long val=grid[r][c];
        grid[r][c]=0;
        long left=dfs(grid,r,c-1);
        long right=dfs(grid,r,c+1);
        long up=dfs(grid,r-1,c);
        long down=dfs(grid,r+1,c);
        return val+left+right+up+down;
    }

    public int countIslands(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    if((long)dfs(grid,i,j)%k==0){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
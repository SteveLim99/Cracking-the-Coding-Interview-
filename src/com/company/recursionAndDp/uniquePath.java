package com.company.recursionAndDp;

public class uniquePath {
    public int uniquePaths_bf(int m, int n) {
        return paths(m-1,0,n-1);
    }

    public int paths(int y, int x, int xLim){
        int total = 0;
        if(y == 0 && x == xLim) return 1;
        if(y-1>=0) total += paths(y-1,x,xLim);
        if(x+1<=xLim) total += paths(y,x+1,xLim);
        return total;
    }

    public int uniquePaths_opti(int m, int n) {
        int[][] grid = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i==0||j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int yMax = obstacleGrid.length;
        int xMax = obstacleGrid[0].length;
        for(int y = 0; y < yMax; y++){
            int[] curr = obstacleGrid[y];
            for(int x = 0; x < xMax; x++){
                int isObs = curr[x];
                if(isObs != 1){
                    if(y == 0){
                        if(x!=0 && obstacleGrid[y][x-1] == 0) obstacleGrid[y][x] = 0;
                        else obstacleGrid[y][x] =1;
                    } else if(x == 0){
                        if(y!=0 && obstacleGrid[y-1][x] == 0) obstacleGrid[y][x] = 0;
                        else obstacleGrid[y][x] = 1;
                    }
                    else obstacleGrid[y][x] = obstacleGrid[y-1][x] + obstacleGrid[y][x-1];
                } else obstacleGrid[y][x] = 0;
            }
        }
        return obstacleGrid[yMax-1][xMax-1];
    }
}

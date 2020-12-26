package com.company.recursionAndDp;

public class maxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) max = Math.max(max,dfs(grid,j,i));
            }
        }
        return max;
    }

    private int dfs(int[][] grid, int x, int y){
        if(x < 0 || y < 0 || y >= grid.length || x >= grid[0].length || grid[y][x] == 0) return 0;

        int total = 1;
        grid[y][x] = 0;
        total += dfs(grid,x+1,y);
        total += dfs(grid,x,y+1);
        total += dfs(grid,x-1,y);
        total += dfs(grid,x,y-1);
        return total;
    }
}

package com.company.recursionAndDp;

public class minPathSum {
    public int minPathSum(int[][] grid) {
        int lowest = backtrack(grid,0,0,0);
        return lowest;
    }

    private int backtrack(int[][] grid, int x, int y, int count){
        int lowest = 2147483647;
        if(x == grid[0].length || y == grid.length) return -1;
        if(x == grid[0].length-1 && y == grid.length-1){
            return count + grid[y][x];
        }

        if(x < grid[0].length){
            int tmp = backtrack(grid,x+1,y,count+grid[y][x]);
            if(tmp < lowest && tmp != -1) lowest = tmp;
        }

        if(y < grid.length){
            int tmp = backtrack(grid,x,y+1,count+grid[y][x]);
            if(tmp < lowest && tmp != -1) lowest = tmp;
        }
        return lowest;
    }
}

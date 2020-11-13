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

    // Here we utilize memoization again, the fibonnaci method
    // Notice how instead of just simply adding up the sum of the top and bottom, we actually pick between them
    // This simulates us traversing the grid and comparing the right and left step to see which one is smaller and then proceed to add them up
    // The end of the grid is the path with the smallest sum
    public int minPathSum_memoization(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(i == 0 && j == 0) continue;
                int sum = 0;
                if(i - 1 >= 0 && j - 1 >= 0) sum += Math.min(grid[i-1][j],grid[i][j-1]);
                else if(i - 1 >= 0) sum += grid[i-1][j];
                else sum += grid[i][j-1];
                sum += grid[i][j];
                grid[i][j] = sum;
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}

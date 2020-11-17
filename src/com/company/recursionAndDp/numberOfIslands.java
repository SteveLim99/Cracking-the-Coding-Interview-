package com.company.recursionAndDp;

public class numberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,j,i);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y){
        if(x >= grid[0].length || y >= grid.length) return;
        if(x < 0 || y < 0) return;
        if(grid[y][x] == '0') return;

        grid[y][x] = '0';
        dfs(grid,x,y+1);
        dfs(grid,x+1,y);
        dfs(grid,x,y-1);
        dfs(grid,x-1,y);
    }
}

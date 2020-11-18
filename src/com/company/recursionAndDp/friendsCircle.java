package com.company.recursionAndDp;

public class friendsCircle {
    public int findCircleNum(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++){
            if(!visited[i]){
                count++;
                friendsGroup(M,i,visited);
            }
        }
        return count;
    }

    private void friendsGroup(int[][] M, int y, boolean[] visited){
        if(y >= M.length || visited[y]) return;
        visited[y] = true;

        for(int i = 0; i < M[y].length; i++){
            if(M[y][i] == 1 && !visited[i]) friendsGroup(M,i,visited);
        }
    }
}

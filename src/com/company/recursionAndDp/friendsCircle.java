package com.company.recursionAndDp;

public class friendsCircle {
    public int findCircleNum_opti(int[][] M) {
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++){
            if(!visited[i]){
                count++;
                friendsGroup_opti(M,i,visited);
            }
        }
        return count;
    }

    private void friendsGroup_opti(int[][] M, int y, boolean[] visited){
        if(y >= M.length || visited[y]) return;
        visited[y] = true;

        for(int i = 0; i < M[y].length; i++){
            if(M[y][i] == 1 && !visited[i]) friendsGroup_opti(M,i,visited);
        }
    }

    public int findCircleNum_1(int[][] M) {
        int count = 0;
        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1){
                    count++;
                    friendsGroup_1(M,i,0,-1);
                    break;
                }
            }
        }
        return count;
    }

    private void friendsGroup_1(int[][] M, int y, int x, int prev){
        if(y >= M.length || x >= M[0].length) return;

        for(int i = 0; i < M[y].length; i++){
            if(M[y][i] == 1){
                M[y][i] = 0;
                if(i != y && i != prev) friendsGroup_1(M,i,0,y);
            }
        }
    }
}

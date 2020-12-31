package com.company.arrays_and_strings;

public class rotateImage {
    public void rotate_1(int[][] matrix) {
        int startX = 0, startY = 0;
        int endX = matrix[0].length, endY = matrix.length-1;
        int targetX = endX / 2, targetY = (endY+1)/2;

        while(startX < targetX && startY < targetY){
            mutate(matrix,startY,endY,startX,endX);
            startX++;
            startY++;

            endX--;
            endY--;
        }
    }

    private void mutate(int[][] matrix, int startY, int endY, int startX, int endX){
        int y = 0, x = 0;
        for(int i = startX; i < endX-1; i++){
            int topR = matrix[startY+y][endX-1];
            int topL = matrix[startY][i];
            int bottomR = matrix[endY][endX-1-x];
            int bottomL = matrix[endY - y][startX];

            matrix[startY+y][endX-1] = topL;
            matrix[startY][i] = bottomL;
            matrix[endY][endX-1-x] = topR;
            matrix[endY-y][startX] = bottomR;

            y++;
            x++;
        }
    }
}

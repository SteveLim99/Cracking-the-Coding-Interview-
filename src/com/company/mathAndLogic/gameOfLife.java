package com.company.mathAndLogic;

import java.util.ArrayList;
import java.util.List;

public class gameOfLife {
    public void gameOfLife(int[][] board) {
        List<List<Integer>> tmpBoard = new ArrayList();
        int xLim = board[0].length;
        int yLim = board.length;
        for(int i = 0; i < yLim; i ++){
            List<Integer> tmp = new ArrayList();
            for(int j = 0; j < xLim; j++){
                int score = 0;
                if(i+1 < yLim) score += board[i+1][j];
                if(j+1 < xLim) score += board[i][j+1];
                if(i-1 >= 0) score += board[i-1][j];
                if(j-1 >= 0) score += board[i][j-1];
                if(i+1 < yLim && j+1 < xLim) score += board[i+1][j+1];
                if(i+1 < yLim && j-1 >= 0) score += board[i+1][j-1];
                if(i-1 >= 0 && j+1 < xLim) score += board[i-1][j+1];
                if(i-1 >= 0 && j-1 >= 0) score += board[i-1][j-1];
                tmp.add(score);
            }
            tmpBoard.add(tmp);
        }

        for(int i = 0; i < yLim; i++){
            for(int j = 0; j < xLim; j++){
                int score = tmpBoard.get(i).get(j);
                int curr = board[i][j];
                if(curr == 1){
                    if(score < 2) board[i][j] = 0;
                    else if(score > 1 && score < 4) board[i][j] = 1;
                    else board[i][j] = 0;
                } else{
                    if(score == 3) board[i][j] = 1;
                }


            }
        }
    }
}

package com.company.arrays_and_strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class candyCrush {
    public int[][] candyCrush_1(int[][] board) {
        while(true){
            HashMap<Integer, Set<Integer>> map = new HashMap();
            check(board,map);

            if(map.size() == 0) break;
            updateBoard(board,map);
        }
        return board;
    }

    private void check(int[][] board, HashMap<Integer,Set<Integer>> map){
        for(int k = 0; k < board.length; k++){
            int[] i = board[k];
            for(int j = 2; j < i.length; j++){
                int target = i[j];
                if(target != 0 && i[j-2] == target && i[j-1] == target){
                    Set<Integer> jMZero = map.getOrDefault(j,new HashSet());
                    Set<Integer> jMOne = map.getOrDefault(j-1,new HashSet());
                    Set<Integer> jMTwo = map.getOrDefault(j-2,new HashSet());
                    jMZero.add(k);
                    jMOne.add(k);
                    jMTwo.add(k);
                    map.put(j,jMZero);
                    map.put(j-1,jMOne);
                    map.put(j-2,jMTwo);
                }
            }
        }

        for(int i = 0; i < board[0].length; i++){
            for(int j = 2; j < board.length; j++){
                int target = board[j][i];
                if(target != 0 && board[j-1][i] == target && board[j-2][i] == target){
                    Set<Integer> tmp = map.getOrDefault(i,new HashSet());
                    tmp.add(j);
                    tmp.add(j-1);
                    tmp.add(j-2);
                    map.put(i,tmp);
                }
            }
        }
    }

    public int[][] candyCrush_2(int[][] board) {
        while(true){
            HashMap<Integer,Set<Integer>> map = new HashMap();
            checkHori(board,map);
            checkVerti(board,map);

            if(map.size() == 0) break;
            updateBoard(board,map);
        }
        return board;
    }

    private void checkHori(int[][] board, HashMap<Integer,Set<Integer>> map){
        for(int k = 0; k < board.length; k++){
            int[] i = board[k];
            for(int j = 2; j < i.length; j++){
                int target = i[j];
                if(target != 0 && i[j-2] == target && i[j-1] == target){
                    Set<Integer> jMZero = map.getOrDefault(j,new HashSet());
                    Set<Integer> jMOne = map.getOrDefault(j-1,new HashSet());
                    Set<Integer> jMTwo = map.getOrDefault(j-2,new HashSet());
                    jMZero.add(k);
                    jMOne.add(k);
                    jMTwo.add(k);
                    map.put(j,jMZero);
                    map.put(j-1,jMOne);
                    map.put(j-2,jMTwo);
                }
            }
        }
    }

    private void checkVerti(int[][] board, HashMap<Integer,Set<Integer>> map){
        for(int i = 0; i < board[0].length; i++){
            for(int j = 2; j < board.length; j++){
                int target = board[j][i];
                if(target != 0 && board[j-1][i] == target && board[j-2][i] == target){
                    Set<Integer> tmp = map.getOrDefault(i,new HashSet());
                    tmp.add(j);
                    tmp.add(j-1);
                    tmp.add(j-2);
                    map.put(i,tmp);
                }
            }
        }
    }

    private void updateBoard(int[][] board, HashMap<Integer,Set<Integer>> map){
        for(int i : map.keySet()){
            Set<Integer> conv = map.get(i);
            Stack<Integer> nonZeros = new Stack();

            for(int j = 0; j < board.length; j++){
                if(board[j][i] != 0 && !conv.contains(j)) nonZeros.add(board[j][i]);
                board[j][i] = 0;
            }

            int head = board.length - 1;
            while(!nonZeros.isEmpty()){
                board[head][i] = nonZeros.pop();
                head--;
            }
        }
    }
}

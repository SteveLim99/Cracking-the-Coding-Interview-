package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class zeroMatrix {

    public int[][] zeroMatrix(int[][] array){
        if(array.length <= 0 || array[0].length <= 0) return array;
        int i = array.length;
        int j = array[0].length;
        List row = new ArrayList();
        List col = new ArrayList();

        for(int y = 0; y < i; y++){
            for(int x = 0; x < j; x++){
                if(array[y][x] == 0){
                    row.add(y);
                    col.add(x);
                }
            }
        }

        for(Object r : row){
            int curr = (int) r;
            for(int x = 0; x < j; x++){
                array[curr][x] = 0;
            }
        }

        for(Object c : col){
            int curr = (int) c;
            for (int y = 0; y < i; y++){
                array[y][curr] = 0;
            }
        }

        return array;
    }
}

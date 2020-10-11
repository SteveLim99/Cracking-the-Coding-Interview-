package com.company.arrays_and_strings;

public class rotateMatrix {

    private boolean validate(int[][] array){
        boolean valid = true;
        int j = array.length;
        if(j<= 0) return false;
        int i = array[0].length;
        if(j!=i) valid = false;
        return valid;
    }

    public int[][] rotateMatrix_imp_1(int[][] array){
        if(validate(array)) {
            int j = array.length;
            int i = array[0].length;
            int[][] tmp = new int[j][i];
            for (int y = 0; y < j; y++) {
                for (int x = 0; x < i; x++) {
                    tmp[y][x] = array[j - x - 1][y];
                }
            }
            return tmp;
        } return array;
    }

    public int[][] rotateMatrix_tmp_2(int[][] array){
        if(validate(array)){
            int j = array.length;
            int i = array[0].length;
        } return array;
    }
}

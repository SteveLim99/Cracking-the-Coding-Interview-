package com.company.recursionAndDp;

public class rangeSumQuery2D {
    int[][] matrix;
    int[][]df;
    int rows;
    int cols;

    public rangeSumQuery2D(int[][] matrix) {
        if(matrix.length > 0 && matrix[0].length > 0) {
            this.matrix = matrix;
            this.rows = matrix.length;
            this.cols = matrix[0].length;
        }
    }

    public int sumRegion_1(int row1, int col1, int row2, int col2) {
        if(row1 >= this.rows || col1 >= this.cols || row2 >= this.rows || col2 >= this.cols ) return 0;
        if(row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0 ) return 0;

        int total = 0;
        for(int i = row1; i <= row2; i++){
            for(int j = col1; j <= col2; j++){
                if(i >= row1 && i <= row2 && j >= col1 && j <= col2) total += matrix[i][j];
            }
        }
        return total;
    }
}

package com.company.recursionAndDp;

public class rangeSumQuery2D {
    int[][] matrix;
    int[][] dp;
    int rows;
    int cols;

    public rangeSumQuery2D(int[][] matrix, boolean placeHolder) {
        if(matrix.length > 0 && matrix[0].length > 0) {
            this.matrix = matrix;
            this.rows = matrix.length;
            this.cols = matrix[0].length;
        }
    }

    public rangeSumQuery2D(int[][] matrix) {
        if(matrix.length > 0 && matrix[0].length > 0) {
            dp = new int[matrix.length+1][matrix[0].length+1];
            for(int i = 1; i <= matrix.length; i++ ){
                for(int j = 1; j <= matrix[0].length; j++){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i-1][j-1];

                }
            }
        }
    }

    public int sumRegion_opti(int row1, int col1, int row2, int col2) {
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
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

package com.company.recursionAndDp;

public class uniquePath {
    public int uniquePaths_bf(int m, int n) {
        return paths(m-1,0,n-1);
    }

    public int paths(int y, int x, int xLim){
        int total = 0;
        if(y == 0 && x == xLim) return 1;
        if(y-1>=0) total += paths(y-1,x,xLim);
        if(x+1<=xLim) total += paths(y,x+1,xLim);
        return total;
    }
}

package com.company.recursionAndDp;

public class tripleStep {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int a = 0;
        int b = 1;
        int c = 1;
        for(int i = 0; i < n-3; i++){
            int tmp = a+ b + c;
            a = b;
            b = c;
            c = tmp;
        }
        return a+b+c;
    }
}

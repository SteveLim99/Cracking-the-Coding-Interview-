package com.company.mathAndLogic;

public class palindromeNumbers {
    public boolean isPalindrome(int x) {
        if( x < 0 || x % 10 == 0 && x != 0 ) return false;
        int tmp = 0, xSto = x;
        while(x!=0){
            tmp = (tmp * 10) + (x % 10);
            x = x/10;
        }
        return tmp == xSto;
    }
}

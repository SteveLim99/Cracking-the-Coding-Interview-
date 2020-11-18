package com.company.sliding_window;

public class grumpyBookStoreOwner {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum = 0, tmp = 0, maxSum = 0;
        for(int j = 0 ; j < customers.length; j++){
            if(grumpy[j] == 0) sum += customers[j];
        }

        tmp = sum;
        for(int i = 0; i < X; i++){
            if(grumpy[i] == 1) tmp += customers[i];
        }
        if(tmp > maxSum) maxSum = tmp;

        for(int i = 1; i < customers.length; i++){
            if(i + X - 1 >= customers.length) break;
            tmp = sum;
            for(int j = i; j < i+X; j++ ){
                if(grumpy[j] == 1) tmp += customers[j];
            }
            if(tmp > maxSum) maxSum = tmp;
        }

        return maxSum;
    }
}

package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class coinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        List<Integer> coinCount = new ArrayList();
        backtracking(coinCount, 0, 0, coins, amount);
        return (coinCount.size() == 0) ? -1 : Collections.min(coinCount);
    }

    private void backtracking(List<Integer> coinCount, int count, long coinVal, int[] coins, int amount){
        if (coinVal == amount){
            coinCount.add(count);
        }

        if (coinVal < amount) {
            for(int i : coins){
                coinVal += i;
                backtracking(coinCount, count+1, coinVal, coins, amount);
                coinVal -= i;
            }
        }
    }
}
}

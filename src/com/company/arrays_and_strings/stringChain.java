package com.company.arrays_and_strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class stringChain {
    public int longestStrChain(String[] words) {
        int max = 0,  count = 0;
        Arrays.sort(words, Comparator.comparing(String::length));
        HashMap<String, Integer> maps = new HashMap();

        for(String curr : words){
            String sto = "";

            for(int i = 0; i < curr.length(); i++){
                String tmp = curr.substring(0,i) + curr.substring(i+1);
                max = Math.max(maps.getOrDefault(tmp,0)+1,max);
                if(maps.containsKey(tmp)) sto = tmp;
            }

            maps.put(curr,maps.getOrDefault(sto,0)+1);
        }

        return max;
    }
}

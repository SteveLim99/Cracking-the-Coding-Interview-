package com.company.arrays_and_strings;

import java.util.List;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] mem = new boolean[s.length()+1];
        mem[0] = true;

        for(int i = 1; i < s.length()+1; i++){
            for(int j = 0; j < i; j++){
                if(mem[j] && wordDict.contains(s.substring(j,i))){
                    mem[i] = true;
                    break;
                }
            }
        }

        return mem[s.length()];
    }
}

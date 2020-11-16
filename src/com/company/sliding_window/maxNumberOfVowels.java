package com.company.sliding_window;

public class maxNumberOfVowels {
    public int maxVowels(String s, int k) {
        int i = 0, j, count = 0, max = 0;

        for(int x = 0; x < k; x++){
            char curr = s.charAt(x);
            if(isVowel(curr)) {
                max++;
                count++;
            }
        }

        for(j = k; j < s.length(); j++){
            char curr = s.charAt(j);
            if(max == k) return k;
            if(isVowel(s.charAt(i++))) count--;
            if(isVowel(curr)) count++;
            if(count > max) max = count;
        }

        return max;
    }

    private boolean isVowel(char curr){
        return (curr == 'a' || curr == 'e' || curr == 'i' || curr == 'o' || curr == 'u');
    }
}

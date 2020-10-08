package com.company.arrays_and_strings;

public class palindromePerm {
    public boolean palindromePermuation(String input){
        input = input.replaceAll("\\s", "");
        int len = input.length();
        boolean[] allChars = new boolean[128];
        for(int i = 0; i < len; i++){
            int curr = input.charAt(i);
            if(allChars[curr]){
                allChars[curr] = false;
                continue;
            }
            allChars[curr] = true;
        }

        int count = 0;
        for(boolean bool : allChars){
            if(bool){
                count += 1;
                if(count > 1){
                    return false;
                }
            }
        }
        return true;
    }
}

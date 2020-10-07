package com.company.arrays_and_strings;

public class isUnique {
    private String inputString;

    public isUnique(String input){
        this.inputString = input;
    }

    public boolean checkUnique(){
        inputString = inputString.toLowerCase();
        int len = inputString.length();
        for(int i = 0; i < len-1; i++){
            char curr = inputString.charAt(i);
            for(int j = i+1; j < len; j++ ){
                char lookAhead = inputString.charAt(j);
                if(curr == lookAhead){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkUniqueOpti(){
        int tmp = this.inputString.length();
        if (tmp > 128) return false;

        boolean[] allChar = new boolean[128];
        for(int i = 0; i < tmp; i++){
            // Optimised solution utilizes the ASCII value of the character itself instead of the actual character
            int curr = inputString.charAt(i);
            if(allChar[curr]){
                return false;
            }
            allChar[curr] = true;
        }
        return true;
    }

}

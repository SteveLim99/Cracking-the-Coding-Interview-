package com.company.arrays_and_strings;

public class stringComp {

    public String compression(String input){
        char[] inputArr = input.toCharArray();
        int len = input.length();
        if(len <= 0) return input;

        int newLen = 0;
        int count = 0;
        char currComp = inputArr[0];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            char curr = inputArr[i];
            if(curr != currComp){
                sb.append(currComp + Integer.toString(count));
                currComp = curr;
                newLen += 2;
                count = 0;
            }
            count += 1;
            if(i == len-1) {
                sb.append(currComp + Integer.toString(count));
                newLen += 2;
            }
        }

        if(newLen < len) return sb.toString();
        else return input;
    }
}

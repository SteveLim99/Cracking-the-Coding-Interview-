package com.company.arrays_and_strings;

public class stringComp {

    public String compression(String input){
        int len = input.length();
        if(len <= 0) return input;

        int newLen = 0;
        int count = 0;
        char currComp = input.charAt(0);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len; i++){
            char curr = input.charAt(i);
            if(curr != currComp){
                sb.append(currComp);
                sb.append(count);
                currComp = curr;
                newLen += 2;
                count = 0;
            }
            count++;
            if(i == len-1){
                sb.append(currComp);
                sb.append(count);
                newLen += 2;
            }
        }

        return newLen < len ? sb.toString() : input;
    }

    public String optimizedCompression(String input){
        StringBuilder sb = new StringBuilder();
        int len = input.length();
        int newLen = 0;
        int count = 0;

        for(int i = 0; i < len; i ++){
            count++;
            if(i == len - 1 || input.charAt(i) != input.charAt(i+1)){
                sb.append(input.charAt(i));
                sb.append(count);
                newLen += 2;
                count = 0;
            }
        }

        return newLen < len ? sb.toString() : input;
    }
}

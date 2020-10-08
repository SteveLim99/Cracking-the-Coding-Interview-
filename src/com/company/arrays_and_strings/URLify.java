package com.company.arrays_and_strings;

public class URLify {

    public String URLify(String input, int inputLen){
        if (inputLen <= 0) return input;

        StringBuilder sb = new StringBuilder();
        char[] newInput = input.toCharArray();
        for(int i = 0; i < inputLen; i++){
            if(newInput[i] == ' '){
                sb.append("%20");
                continue;
            }
            sb.append(newInput[i]);
        }
        return sb.toString();
    }
}

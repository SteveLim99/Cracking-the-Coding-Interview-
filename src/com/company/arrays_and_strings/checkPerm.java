package com.company.arrays_and_strings;

public class checkPerm {

    public boolean checkPermutation(String input, String compare){
        int inputLen = input.length();
        int compareLen = compare.length();

        if(inputLen != compareLen){
            return false;
        }

        int inputCount = 0;
        int compareCount = 0;

        for(int i = 0; i < inputLen; i++){
            int inputCurr = input.charAt(i);
            int compareCurr = compare.charAt(i);
            inputCount += inputCurr;
            compareCount += compareCurr;
        }

        return inputCount != compareCount ? false : true;
    }
}

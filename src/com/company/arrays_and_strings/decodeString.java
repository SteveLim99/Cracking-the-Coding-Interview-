package com.company.arrays_and_strings;

import java.util.Stack;

public class decodeString {
    public String decodeString(String s) {
        Stack<String> resStore = new Stack();
        Stack<Integer> intStore = new Stack();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(Character.isDigit(curr)){
                int j = i;

                StringBuilder sb = new StringBuilder();
                while(Character.isDigit(s.charAt(j))){
                    sb.append(s.charAt(j));
                    j++;
                }

                intStore.add(Integer.parseInt(sb.toString()));
                i = j - 1;
            } else if(curr == '['){
                resStore.add(res.toString());
                res = new StringBuilder();
            } else if(curr == ']'){
                int loop = intStore.pop();
                String loopStr = res.toString();
                for(int j = 0; j < loop-1; j++){
                    res.append(loopStr);
                }

                StringBuilder newRes = new StringBuilder(resStore.pop());
                newRes.append(res.toString());
                res = newRes;
            } else{
                res.append(curr);
            }
        }

        return res.toString();
    }
}

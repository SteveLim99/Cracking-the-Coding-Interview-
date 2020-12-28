package com.company.stackAndQueues;

import java.util.Stack;

public class removeKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k>=len) return "0";

        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<len){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());

        i = sb.length() - 1;
        while(i >= 1 && sb.charAt(i) == '0'){
            sb.deleteCharAt(i--);
        }

        return sb.reverse().toString();
    }
}

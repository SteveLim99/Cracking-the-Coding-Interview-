package com.company.arrays_and_strings;

import java.util.Stack;

public class minRemovalForValidParen {
    public String minRemovalForValidParen_1(String s) {
        int open = 0, close = 0;

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(') open++;
            else if (curr == ')') close++;
        }

        int min = Math.max(open,close) - Math.abs(open-close);

        int remClose = close;
        open = 0;
        close = 0;
        Stack<Character> brackets = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' && open < min && brackets.size() + 1 <= remClose){
                open++;
                sb.append(curr);
                brackets.add(curr);
            }
            else if (curr == ')' && close < min && brackets.size() != 0) {
                close++;
                remClose--;
                brackets.pop();
                sb.append(curr);
            }
            else if (curr != '(' && curr != ')') sb.append(curr);
            else {
                if(curr == ')') remClose--;
            }
        }

        return sb.toString();
    }

    public String minRemovalForValidParen_2(String s) {
        StringBuilder sb = new StringBuilder(s);

        int open = 0, close = 0;
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(') open++;
            else if(curr == ')'){
                if(open != 0) {
                    open--;
                    close++;
                }
                else sb.setCharAt(i,'#');
            }
        }

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '(' && close != 0) close--;
            else if (curr =='(' && close == 0) sb.setCharAt(i,'#');
        }

        for(int i = 0; i < sb.length(); i++){
            if(sb.charAt(i) == '#') {
                sb.deleteCharAt(i);
                i--;
            }
        }

        return sb.toString();
    }
}

package com.company.interviewPrep;

public class breakPalindrome {
    public String breakPalindrome(String palindrome) {
        StringBuilder sb = new StringBuilder();
        boolean swapped = false;
        int length = palindrome.length();

        for(int i = 0; i < length; i++){
            char curr = palindrome.charAt(i);
            if(!swapped && curr != 'a' && i!=length/2){
                sb.append('a');
                swapped = true;
            } else sb.append(curr);
        }
        if(!swapped) sb.setCharAt(length-1,'b');
        return length == 1 ? "" : sb.toString();
    }
}

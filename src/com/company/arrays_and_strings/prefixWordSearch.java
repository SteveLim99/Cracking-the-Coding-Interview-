package com.company.arrays_and_strings;

public class prefixWordSearch {
    public int isPrefixOfWord_1(String sentence, String searchWord) {
        int searchLen = searchWord.length(), j = 0, head = 0;
        boolean pref = true;
        for(int i = 0; i < sentence.length(); i++){
            char curr = sentence.charAt(i);
            if(curr == searchWord.charAt(j) && pref) {
                if(++j == searchWord.length()) return head + 1;
            }
            else if(curr == ' '){
                head++;
                j = 0;
                pref = true;
            } else{
                pref = false;
            }
        }
        return -1;
    }
}

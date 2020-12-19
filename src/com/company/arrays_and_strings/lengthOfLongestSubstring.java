package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lengthOfLongestSubstring {
    public int lengthOfLongestSubstring_1(String s) {
        List<String> unique = new ArrayList();
        int i, j = 0, tmp = 0, max = 0;

        for(i = 0; i < s.length(); i++){
            String curr = Character.toString(s.charAt(i));

            if(unique.contains(curr)){
                boolean found = false;
                while(!found){
                    String tail = Character.toString(s.charAt(j));
                    unique.remove(tail);
                    if(tail.equals(curr)) found = true;
                    j++;
                }
                if(tmp > max) max = tmp;
                tmp = 1 + i - j;
                unique.add(curr);
            }

            else {
                unique.add(curr);
                max = Math.max(++tmp,max);
            }
        }

        return max;
    }

    public int lengthOfLongestSubstring_2(String s) {
        Set<Character> unique = new HashSet();
        int i, j = 0, tmp = 0, max = 0;

        for(i = 0; i < s.length(); i++){
            char curr = s.charAt(i);

            if(unique.contains(curr)){
                boolean found = false;
                while(!found){
                    char tail = s.charAt(j);
                    unique.remove(tail);
                    if(tail == curr) found = true;
                    j++;
                }
                if(tmp > max) max = tmp;
                tmp = 1 + i - j;
                unique.add(curr);
            }

            else {
                unique.add(curr);
                max = Math.max(++tmp,max);
            }
        }

        return max;
    }
}

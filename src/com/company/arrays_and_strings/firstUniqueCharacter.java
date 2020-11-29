package com.company.arrays_and_strings;

import java.util.HashMap;

public class firstUniqueCharacter {
    public int firstUniqChar_1(String s) {
        HashMap<Character,Integer> chars = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(chars.containsKey(curr)) chars.put(curr,chars.get(curr)+1);
            else chars.put(curr,1);
        }

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(chars.get(curr) == 1) return i;
        }
        return -1;
    }
}

package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class phoneNumberCombi {
    public List<String> letterCombinations_1(String digits) {
        HashMap<Character, char[]> map = new HashMap();
        map.put('2', new char[]{'a','b','c'});
        map.put('3', new char[]{'d','e','f'});
        map.put('4', new char[]{'g','h','i'});
        map.put('5', new char[]{'j','k','l'});
        map.put('6', new char[]{'m','n','o'});
        map.put('7', new char[]{'p','q','r','s'});
        map.put('8', new char[]{'t','u','v'});
        map.put('9', new char[]{'w','x','y','z'});

        List<String> res = new ArrayList();
        backtrack(map,res,new StringBuilder(),0,digits);
        return res;
    }

    private void backtrack(HashMap<Character, char[]> map, List<String> res, StringBuilder sb, int head, String digits){
        if(head > digits.length()) return;
        if(sb.length() == digits.length()) {
            if(!sb.toString().equals("")) res.add(sb.toString());
            return;
        }

        char[] combis = map.get(digits.charAt(head));
        for(int i = 0; i < combis.length; i++){
            sb.append(combis[i]);
            backtrack(map,res,sb,head+1,digits);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}

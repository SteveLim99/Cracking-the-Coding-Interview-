package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class decodeWays {
    public int numDecodings_1(String s) {
        List<String> res = new ArrayList();
        backtrack(s,res,new StringBuilder(), 0);
        return res.size();
    }

    private void backtrack(String s, List<String> res, StringBuilder sb, int head){
        if(sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }
        if(head >= s.length()) return;

        char curr = s.charAt(head);
        String tmp = "27";
        if(head + 2 <= s.length() && curr != '0') tmp = s.substring(head,head+2);
        if(Integer.parseInt(tmp) < 27) sb.append(tmp);
        backtrack(s,res,sb,head+2);
        if(Integer.parseInt(tmp) < 27) sb.delete(sb.length()-2,sb.length());

        if (curr != '0' && (tmp != "20" || tmp != "10")) sb.append(s.charAt(head));
        backtrack(s,res,sb,head+1);
        if (curr != '0'  && (tmp != "20" || tmp != "10")) sb.deleteCharAt(sb.length()-1);
    }
}

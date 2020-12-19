package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class decodeWays {
    public int numDecodings_1(String s) {
        List<String> res = new ArrayList();
        backtrack(s,res,new StringBuilder(), 0);
        return res.size();
    }

    public int numDecodings_2(String s) {
        if(s.length() == 1 || s.charAt(0) == '0') return (s.charAt(0) == '0') ? 0 : 1;

        int i = 0;
        int[] res = new int[s.length()+1];
        res[0] = 1;
        res[1] = (s.charAt(i) == '0') ? 0 : 1;
        for(i = 2; i <= s.length(); i++){
            int first = Integer.valueOf(s.substring(i - 1, i));
            System.out.println(first);
            int second = Integer.valueOf(s.substring(i - 2, i));
            System.out.println(second);
            if (first >= 1 && first <= 9) res[i] += res[i-1];
            if (second >= 10 && second <= 26) res[i] += res[i-2];
        }
        return res[i-1];
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

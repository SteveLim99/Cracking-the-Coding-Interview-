package com.company.interviewPrep;

import java.util.ArrayList;
import java.util.List;

public class sharePurchases {

    public long analyzeSharePrices_backtrack(String s){
        List<String> total = new ArrayList<>();
        s = s.toUpperCase();
        long value = backtrack(total,s,new StringBuilder(),0);
        return value;
    }

    private long backtrack(List<String> total, String s, StringBuilder tmp, int head){
        if(head > s.length()) return 0;
        String tmpStr = tmp.toString();
        if(tmpStr.contains("A") && tmpStr.contains("B") && tmpStr.contains("C")) {
            char start = tmp.charAt(0);
            char end = tmp.charAt(tmp.length()-1);
            StringBuilder startEnd = new StringBuilder();
            if(start>end){
                startEnd.append(end);
                startEnd.append(start);
            } else {
                startEnd.append(start);
                startEnd.append(end);
            }
            String prefix = startEnd.toString();
            if(!total.contains(prefix)){
                System.out.println(prefix);
                total.add(prefix);
                return 1;
            }
        }

        long val = 0;
        for(int i = head; i < s.length(); i ++){
            tmp.append(s.charAt(i));
            val += backtrack(total,s,tmp,head+1);
            tmp.deleteCharAt(tmp.length()-1);
        }
        return val;
    }

}

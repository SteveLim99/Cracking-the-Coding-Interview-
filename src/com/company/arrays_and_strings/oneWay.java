package com.company.arrays_and_strings;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

import static java.lang.Math.abs;

public class oneWay {

    public boolean oneWay(String input, String compared){
        int inputLen = input.length();
        int comparedLen = compared.length();
        int diff = abs(comparedLen - inputLen);

        if(diff > 1){
            return false;
        } else if (diff <= 1){
            Dictionary book = new Hashtable();
            for(int i = 0; i < inputLen; i++){
                int curr = input.charAt(i);
                Object dictCurr = book.get(curr);
                if(dictCurr != null){
                    int currSize = (int) dictCurr;
                    book.remove(curr);
                    book.put(curr, currSize+1);
                    continue;
                }
                book.put(curr,1);
            }
            for(int j = 0; j < comparedLen; j++){
                int curr = compared.charAt(j);
                Object dictCurr = book.get(curr);
                if(dictCurr != null){
                    int currSize = (int) dictCurr;
                    book.remove(curr);
                    if(currSize != 1) book.put(curr, currSize-1);
                    continue;
                }
                book.put(curr,1);
            }
            Enumeration enu = book.elements();
            int totalStepsNeeded = 0;
            while(enu.hasMoreElements()){
                totalStepsNeeded += (int) enu.nextElement();
            }
            if(totalStepsNeeded > 2) return false;
        }
        return true;
    }
}

package com.company.arrays_and_strings;

import java.util.ArrayList;
import java.util.List;

public class stringRotation {
    public boolean stringRotation(String a, String b){
        char[] arrB = b.toCharArray();
        int lenA = a.length();
        int lenB = b.length();
        if(lenA != lenB || lenA <= 0 || lenB <= 0) return false;
        char starting = a.charAt(0);
        List possibleStartingPos = new ArrayList();

        for(int i = 0; i < lenA; i++){
            if(arrB[i] == starting) possibleStartingPos.add(i);
        }

        StringBuilder sb = new StringBuilder();
        boolean sub = false;
        for(Object i : possibleStartingPos){
            int curr = (int) i;
            for(int k = curr; k < lenB; k++){
                sb.append(arrB[k]);
            }
            for(int j = 0; j < curr; j++){
                sb.append(arrB[j]);
            }
            if(sb.toString().equals(a)){
                sub = true;
                break;
            }
            sb.delete(0,lenB);
        }
        return sub;
    }
}

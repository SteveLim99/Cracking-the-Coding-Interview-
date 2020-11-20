package com.company.interviewPrep;

import java.util.ArrayList;
import java.util.List;

public class sharePurchases {

    public long analyzeSharePrices(String s){
        int j, i = 0, total = 0;
        int a = 0, b = 0, c = 0;

        for(j = 0; j < s.length(); j++){
            char curr = s.charAt(j);
            if(curr == 'A') a++;
            if(curr == 'B') b++;
            if(curr == 'C') c++;

            while (a >= 1 && b >= 1 && c >= 1) {
                if(a >= 1 && b >= 1 && c >= 1) total++;
                char currI = s.charAt(i++);
                if (currI == 'A') a--;
                if (currI == 'B') b--;
                if (currI == 'C') c--;
            }
        }

        return total;
    }
}

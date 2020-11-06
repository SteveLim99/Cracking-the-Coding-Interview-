package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.List;

public class parens {
    public List<String> generateParenthesis_unoptimized(int n) {
        List<String> output = new ArrayList();
        backtracing_unoptimized(output, "",0,0,n);
        return output;
    }

    private void backtracing_unoptimized(List<String> output, String tmp, int left, int right, int max){
        if(tmp.length() == max*2){
            output.add(tmp);
            return;
        }

        if(left < max){
            backtracing_unoptimized(output, tmp+"(",left+1,right,max);
        }

        if (right < left){
            backtracing_unoptimized(output, tmp+")",left,right+1,max);
        }
    }
}

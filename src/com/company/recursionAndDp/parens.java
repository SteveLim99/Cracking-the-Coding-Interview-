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

    public List<String> generateParenthesis_opti(int n) {
        List<String> output = new ArrayList();
        backtracing_opti(output, new StringBuilder(),0,0,n);
        return output;
    }

    private void backtracing_opti(List<String> output, StringBuilder sb, int left, int right, int max){
        if(sb.length() == max*2){
            output.add(sb.toString());
            return;
        }

        if(left < max){
            backtracing_opti(output, sb.append("("),left+1,right,max);
            sb.deleteCharAt(sb.length()-1);
        }

        if (right < left){
            backtracing_opti(output, sb.append(")"),left,right+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}

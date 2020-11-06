package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.List;

public class parens {
    public List<String> generateParenthesis_unoptimized(int n) {
        List<String> output = new ArrayList();
        backtracing_unoptimized(output, "",0,0,n);
        return output;
    }

    // The reason this works is because we essentially insert "(" and ")" to balance them out.
    // In backtracking, we have to select options and we have to list out the options available to select for the algorithm to recursively go through them.
    // This works as we want to keep the value of "(" <= n, we recursively add "(" first on every recursive step until we reach n
    // Once we reach n, we start adding the ")" as the condition of ")" is less than "(".

    // These two conditions produce a balanced string!
    private void backtracing_unoptimized(List<String> output, String tmp, int left, int right, int max){
        // The edge case
        if(tmp.length() == max*2){
            output.add(tmp);
            return;
        }

        // The reason we do not need to delete the last index of the string is because everytime we pass the string into backtrackking
        // We are essentially passing in a new String object that has no pointers to the old one
        // Hence the state of the old string presist
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

        // The reason we need to remove the last index in the string builder is because we are passing the same stringbuilder object
        // This can also be seen when we are passing a list during backtracking and have to remove the last case on every iteration
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

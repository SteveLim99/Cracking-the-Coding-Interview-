package com.company.systemDesign;

import java.util.ArrayList;
import java.util.List;

public class maxStack {
    List<Integer> stack;

    /** initialize your data structure here. */
    public maxStack() {
        this.stack = new ArrayList();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        int res = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return res;
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int peekMax() {
        int max  = Integer.MIN_VALUE;
        for(int i = 0; i < stack.size(); i++)
            if(stack.get(i) > max) max = stack.get(i);
        return max;
    }

    public int popMax() {
        int idx = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < stack.size(); i++){
            if(stack.get(i) >= max){
                max = stack.get(i);
                idx = i;
            }
        }
        stack.remove(idx);
        return max;
    }
}

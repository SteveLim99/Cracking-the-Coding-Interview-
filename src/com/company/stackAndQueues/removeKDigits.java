package com.company.stackAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class removeKDigits {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if(k>=len) return "0";

        Stack<Character> stack = new Stack<>();
        int i =0;
        while(i<len){
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());

        i = sb.length() - 1;
        while(i >= 1 && sb.charAt(i) == '0'){
            sb.deleteCharAt(i--);
        }

        return sb.reverse().toString();
    }

    // In java, the dequeu operator is preferred to stack, this can be seen here
    // https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack#:~:text=Using%20the%20Deque%20interface%20removes,(like%20LinkedList%2C%20ArrayDeque).
    public String removeKdigits_2(String num, int k) {
        if(k >= num.length()) return "0";

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : num.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }

        while(k>0) {
            stack.removeLast();
            k--;
        }

        // Remove all zeros from the front of the stack and then if stack is empty, return "0"
        while(!stack.isEmpty() && stack.peekFirst()== '0') stack.removeFirst();
        if(stack.isEmpty()) return "0";

        // build the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}

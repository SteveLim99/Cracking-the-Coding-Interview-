package com.company.stackAndQueues;

public class minStack {
    private class StackNode{
        private int val;
        private StackNode next;

        public StackNode(int val){
            this.val = val;
        }
    }

    private StackNode top;
    private StackNode min = new StackNode(2147483647);
    public minStack() {

    }

    public void push(int x) {
        StackNode stackNode = new StackNode(x);
        stackNode.next = top;
        top = stackNode;
        if(x <= min.val){
            StackNode minNode = new StackNode(x);
            minNode.next = min;
            min = minNode;
        }
    }

    public void pop() {
        if(top.val == min.val){
            min = min.next;
        }
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        return min.val;
    }
}

package com.company.treesAndGraphs;

public class minimalTree {

    public TreeNode minimalTree(int[] input){
        return minimalTree(input, 0, input.length-1);
    }

    private TreeNode minimalTree(int[] input, int start, int end){
        if(end < start) return null;
        int mid = (start+end)/2;
        TreeNode treeNode = new TreeNode(input[mid]);
        treeNode.left = minimalTree(input, start,mid-1);
        treeNode.right = minimalTree(input, mid+1, end);
        return treeNode;
    }
}

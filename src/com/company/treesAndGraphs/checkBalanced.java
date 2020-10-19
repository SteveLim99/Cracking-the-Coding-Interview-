package com.company.treesAndGraphs;

public class checkBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        int left = subTreeHeight(root.left);
        int right = subTreeHeight(root.right);
        return (Math.abs(left - right) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    public int subTreeHeight(TreeNode root){
        if (root==null) return 0;
        int max = 0;

        if(root.left != null || root.right != null){
            int left = subTreeHeight(root.left);
            int right = subTreeHeight(root.right);
            int curr = Math.max(left,right);
            max = Math.max(curr,max);
        }
        return max + 1;
    }
    
}

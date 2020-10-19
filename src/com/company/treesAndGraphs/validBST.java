package com.company.treesAndGraphs;

public class validBST {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean tmp = dfs(root.left, root.val, true, true, root.val) && dfs(root.right, root.val, false, false,root.val);
        return tmp && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean dfs(TreeNode root,int parent, boolean leftRight, boolean iniLeftRight, int mid){
        if(root == null) return true;
        if(leftRight && root.val >= parent) return false;
        if(!leftRight && root.val <= parent) return false;
        if(iniLeftRight && root.val >= mid) return false;
        if(!iniLeftRight && root.val <= mid) return false;

        boolean left = dfs(root.left, root.val, true, iniLeftRight, mid);
        boolean right = dfs(root.right, root.val, false, iniLeftRight, mid);
        return left && right;
    }
}

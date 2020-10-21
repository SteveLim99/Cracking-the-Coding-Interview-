package com.company.treesAndGraphs;

public class isSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return false;
        return compare(s,t) || isSubtree(s.left,t) || isSubtree(s.right,t);
    }

    public boolean compare(TreeNode s, TreeNode t){
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.val != t.val) return false;
        return (s.val == t.val) && compare(s.left, t.left) && compare(s.right, t.right);
    }
}

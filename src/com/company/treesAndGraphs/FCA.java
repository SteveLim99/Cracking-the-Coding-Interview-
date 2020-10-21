package com.company.treesAndGraphs;

public class FCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode LCA = null;
        if(dfs(root,p,q) == 2) LCA = root;

        if(root.left != null) {
            TreeNode tmp = lowestCommonAncestor(root.left, p ,q);
            if(tmp != null) LCA = tmp;
        }
        if(root.right != null){
            TreeNode tmp = lowestCommonAncestor(root.right, p ,q);
            if(tmp != null) LCA = tmp;
        }
        return LCA;
    }


    public int dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return 0;
        int found = 0;
        if(root.val == p.val || root.val == q.val) found++;
        found += dfs(root.left, p, q);
        found += dfs(root.right, p, q);
        return found;
    }
}

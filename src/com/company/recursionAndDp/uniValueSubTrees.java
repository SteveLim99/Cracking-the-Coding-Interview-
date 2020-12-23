package com.company.recursionAndDp;

import com.company.treesAndGraphs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class uniValueSubTrees {
    public int countUnivalSubtrees(TreeNode root) {
        List<TreeNode> tmp = new ArrayList();
        dfs(root,tmp);
        return tmp.size();
    }

    private boolean dfs(TreeNode root, List<TreeNode> tmp){
        if(root == null) return true;
        if(root.left == null && root.right == null) {
            tmp.add(root);
            return true;
        }

        boolean val = true;
        if(root.right != null && root.right.val != root.val) val = false;
        if(root.left != null && root.left.val != root.val) val = false;

        boolean l = dfs(root.left,tmp);
        boolean r = dfs(root.right,tmp);
        if(l && r && val) tmp.add(root);

        return l && r && val;
    }
}

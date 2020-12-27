package com.company.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class sumNumber {
    public int sumNumbers(TreeNode root) {
        List<Integer> res = new ArrayList();
        dfs(root,res,0);

        int count = 0;
        for(int i : res)
            count += i;

        return count;
    }

    private void dfs(TreeNode root, List<Integer> res, int sb){
        if(root == null) return;
        if(root.left == null && root.right == null) res.add(sb*10 + root.val);
        if(root.left != null) dfs(root.left,res,sb*10 + root.val);
        if(root.right != null) dfs(root.right,res,sb*10 + root.val);
    }
}

package com.company.treesAndGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bstToGst {
    public TreeNode bstToGst_1(TreeNode root) {
        List<Integer> tmp = new ArrayList();
        dfs(root,tmp);

        HashMap<Integer, Integer> map = new HashMap();
        int sum = 0;
        for(int i : tmp){
            sum += i;
            map.put(i,sum);
        }

        newNodes(root,map);
        return root;
    }

    private void newNodes(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return;

        root.val = map.get(root.val);
        newNodes(root.left,map);
        newNodes(root.right,map);
    }

    private void dfs(TreeNode root, List<Integer> tmp){
        if(root == null) return;

        dfs(root.right,tmp);
        tmp.add(root.val);
        dfs(root.left,tmp);
    }
}

package com.company.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class Sucessor {
    public TreeNode successor(TreeNode root, TreeNode target){
        List<TreeNode> tmp = new ArrayList<>();
        List<TreeNode> ans = dfs(root,tmp);

        if(ans.isEmpty()) return null;
        for(int i = 0; i < ans.size(); i++){
            if(ans.get(i) == target){
                if(i != ans.size() - 1) return ans.get(i+1);
            }
        }
        return null;
    }

    public List<TreeNode> dfs(TreeNode root, List<TreeNode> tmp){
        if(root == null) return null;

        dfs(root.left,tmp);
        tmp.add(root);
        dfs(root.right,tmp);
        return tmp;
    }

    
}

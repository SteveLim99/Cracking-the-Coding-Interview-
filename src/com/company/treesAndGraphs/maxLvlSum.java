package com.company.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class maxLvlSum {
    public int maxLevelSum_1(TreeNode root) {
        List<TreeNode> currLevel = new ArrayList();
        currLevel.add(root);
        int level = 1;
        int max = root.val;
        int maxLvl = 1;
        while(!currLevel.isEmpty()){
            List<TreeNode> newLevel = new ArrayList();
            int sum = 0;
            for(TreeNode i : currLevel){
                sum += i.val;
                if(i.left != null) newLevel.add(i.left);
                if(i.right != null) newLevel.add(i.right);
            }
            if(sum > max){
                max = sum;
                maxLvl = level;
            }
            level++;
            currLevel = newLevel;
        }
        return maxLvl;
    }
}

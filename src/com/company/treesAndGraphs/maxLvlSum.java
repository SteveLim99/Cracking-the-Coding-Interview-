package com.company.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public int maxLevelSum(TreeNode root) {
        Queue queue = new LinkedList();
        queue.add(root);
        int count = 1;
        int level = 1;
        int max = root.val;
        int maxLvl = 1;
        while(!queue.isEmpty()){
            int sum = 0;
            int nodes = 0;
            while(count != 0){
                TreeNode curr = (TreeNode) queue.remove();
                sum += curr.val;
                if(curr.left != null){
                    queue.add(curr.left);
                    nodes++;
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                    nodes++;
                }
                count--;
            }
            if(sum > max){
                max = sum;
                maxLvl = level;
            }
            level++;
            count = nodes;
        }
        return maxLvl;
    }
}

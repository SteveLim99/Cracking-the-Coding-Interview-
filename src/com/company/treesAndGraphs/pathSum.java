package com.company.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    public boolean hasPathSum_1(TreeNode root, int sum) {
        if(root==null) return false;
        sum -= root.val;
        return (root.left == null && root.right == null && sum == 0) || hasPathSum_1(root.left, sum) || hasPathSum_1(root.right, sum);
    }

    public int pathSum_2(TreeNode root, int sum) {
        if(root==null) return 0;
        return helper_2(root,sum) + pathSum_2(root.left,sum) + pathSum_2(root.right,sum);
    }

    public int helper_2(TreeNode root, int sum){
        int total = 0;
        if(root == null) return 0;
        sum -= root.val;
        if(sum == 0) total ++;

        total += helper_2(root.left, sum);
        total += helper_2(root.right, sum);
        return total;
    }

    public List<List<Integer>> pathSum_ii(TreeNode root, int sum) {
        List<List<Integer>> total = new ArrayList();
        backtrack(root,total,new ArrayList(), sum);
        return total;
    }

    public void backtrack(TreeNode root, List<List<Integer>> total, List<Integer> tmp, int sum){
        if(root == null) return;
        if(root.left == null && root.right == null){
            tmp.add(root.val);
            int sumT = 0;
            for(int i : tmp){
                sumT += i;
            }
            if(sumT == sum) {
                total.add(new ArrayList(tmp));
            }
            tmp.remove(tmp.size() - 1);
            return;
        }

        if(root.left != null){
            tmp.add(root.val);
            backtrack(root.left, total, tmp, sum);
            tmp.remove(tmp.size() - 1);
        }

        if(root.right != null){
            tmp.add(root.val);
            backtrack(root.right, total, tmp,sum);
            tmp.remove(tmp.size() - 1);
        }
    }
}

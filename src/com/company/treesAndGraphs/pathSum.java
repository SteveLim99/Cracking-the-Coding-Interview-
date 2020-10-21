package com.company.treesAndGraphs;

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
}

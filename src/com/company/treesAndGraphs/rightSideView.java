package com.company.treesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightSideView {
    public List<Integer> rightSideView_1(TreeNode root) {
        List<Integer> rightView = new ArrayList();
        if(root == null) return rightView;

        Queue<TreeNode> bfs = new LinkedList();
        bfs.add(root);

        int count = 1;
        while(!bfs.isEmpty()){

            int nextLvl = 0;
            while(count != 0){
                TreeNode curr = bfs.remove();
                if(count == 1) rightView.add(curr.val);

                if(curr.left != null || curr.right != null){
                    if(curr.left != null) bfs.add(curr.left);
                    if(curr.right!=null) bfs.add(curr.right);
                    nextLvl++;
                }

                count--;
            }

            count = nextLvl;
        }

        return rightView;
    }
}

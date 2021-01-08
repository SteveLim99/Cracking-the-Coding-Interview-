package com.company.treesAndGraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class maxWidthOfBinaryTree {
    public int widthOfBinaryTree_1(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList();
        Set<TreeNode> level = new HashSet();
        bfs.offer(root);
        level.add(root);
        int width = 1;

        while(!bfs.isEmpty()){
            int count = bfs.size();
            int lvlCount = level.size();
            int newWidth = 0;
            boolean foundLeft = false, foundLvlHead = false;

            for(int i = 0; i < count; i++){
                TreeNode curr = bfs.poll();

                if(curr == null){
                    if(lvlCount > 0) {
                        if(foundLeft){
                            bfs.offer(null);
                            bfs.offer(null);
                        }

                        if(foundLvlHead) newWidth++;
                    }
                }

                else {
                    level.remove(curr);
                    foundLvlHead = true;
                    lvlCount--;
                    newWidth++;

                    if(curr.left != null){
                        level.add(curr.left);
                        bfs.offer(curr.left);
                        foundLeft = true;
                    } else {
                        if(foundLeft && (lvlCount > 0 || (lvlCount == 0 && curr.right != null))) bfs.offer(null);
                    }

                    if(curr.right != null){
                        level.add(curr.right);
                        bfs.offer(curr.right);
                        foundLeft = true;
                    } else {
                        if(foundLeft && lvlCount > 0)  bfs.offer(null);
                    }
                }

            }

            if(newWidth > width) width = newWidth;
        }
        return width;
    }

    public int widthOfBinaryTree_2(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList();
        Queue<Integer> idx = new LinkedList();
        bfs.offer(root);
        idx.offer(1);
        int max = 1;

        while(!bfs.isEmpty()){
            int count = bfs.size();
            int start = 0, end = 0;
            for(int i = 0; i < count; i++){
                TreeNode currNode = bfs.poll();
                int currIdx = idx.poll();

                if(i == 0) start = currIdx;
                if(i == count-1) end = currIdx;

                if(currNode.left != null){
                    bfs.offer(currNode.left);
                    idx.offer(currIdx * 2);
                }

                if(currNode.right != null){
                    bfs.offer(currNode.right);
                    idx.offer(currIdx * 2 + 1);
                }
            }

            int width = end + 1 - start;
            if(width > max) max = width;
        }

        return max;
    }
}

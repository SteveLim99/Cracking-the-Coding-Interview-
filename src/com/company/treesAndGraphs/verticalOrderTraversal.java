package com.company.treesAndGraphs;

import java.util.*;

public class verticalOrderTraversal {
    public List<List<Integer>> verticalOrder_1(TreeNode root) {
        HashMap<TreeNode, Integer> xMap = new HashMap();
        HashMap<Integer, List<Integer>> map = new HashMap();
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> bfs = new LinkedList();
        if(root != null) {
            bfs.offer(root);
            xMap.put(root,0);
        }

        while(!bfs.isEmpty()){
            int count = bfs.size();

            for(int i = 0; i < count; i++){
                TreeNode curr = bfs.poll();
                int x = xMap.get(curr);
                List<Integer> tmp = map.getOrDefault(x, new ArrayList());
                tmp.add(curr.val);
                map.put(x,tmp);

                if(curr.left != null){
                    bfs.offer(curr.left);
                    xMap.put(curr.left,x-1);
                }

                if(curr.right != null){
                    bfs.offer(curr.right);
                    xMap.put(curr.right,x+1);
                }
            }
        }

        List<Integer> levels = new ArrayList(map.keySet());
        Collections.sort(levels);
        for(int i : levels){
            res.add(map.get(i));
        }

        return res;
    }
}

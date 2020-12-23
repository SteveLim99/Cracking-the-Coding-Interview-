package com.company.recursionAndDp;

import java.util.ArrayList;
import java.util.List;

public class allPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> tmp = new ArrayList();
        tmp.add(0);
        dfs(graph,res,tmp, 0);
        return res;
    }

    private void dfs(int[][] graph, List<List<Integer>> res, List<Integer> tmp, int head){
        if(head == graph.length-1) res.add(new ArrayList(tmp));

        for(int i = 0; i < graph[head].length; i++){
            int curr = graph[head][i];
            graph[head][i] = -1;
            if(curr != -1){
                tmp.add(curr);
                dfs(graph,res,tmp,curr);
                tmp.remove(tmp.size()-1);
            }
            graph[head][i] = curr;
        }
    }
}

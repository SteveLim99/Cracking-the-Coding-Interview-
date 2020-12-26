package com.company.treesAndGraphs;

import java.util.*;

public class killProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList(Arrays.asList(kill));
        Queue<Integer> bfs = new LinkedList();
        HashMap<Integer, List<Integer>> mapping = new HashMap();

        for(int i = 0; i < ppid.size(); i++){
            int curr = ppid.get(i);
            if(mapping.containsKey(curr)){
                List<Integer> tmp = mapping.get(curr);
                tmp.add(pid.get(i));
                mapping.put(curr,tmp);
            } else mapping.put(curr,new ArrayList(Arrays.asList(pid.get(i))));
        }

        if(mapping.containsKey(kill)){
            for(int i : mapping.get(kill))
                bfs.offer(i);
        } else return res;


        while(!bfs.isEmpty()){
            int count = bfs.size();

            while(count != 0){
                int curr = bfs.poll();
                res.add(curr);
                if(mapping.containsKey(curr)){
                    for(int i : mapping.get(curr))
                        bfs.offer(i);
                }
                count--;
            }
        }

        return res;
    }
}

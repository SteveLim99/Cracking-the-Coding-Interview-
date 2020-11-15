package com.company.interviewPrep;

import java.util.ArrayList;
import java.util.List;

public class teams {
    private int num;
    private int[] skillLevel;
    private int minTeamMembers;
    private int minLvl;
    private int maxLvl;

    public teams(int num, int[] skillLevel, int minTeamMembers, int minLvl, int maxLvl){
        this.num = num;
        this.skillLevel = skillLevel;
        this.minTeamMembers = minTeamMembers;
        this.minLvl = minLvl;
        this.maxLvl = maxLvl;
    }

    public int calcTeams(){
        int minLvl = this.minLvl;
        int maxLvl = this.maxLvl;
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i = 0; i < skillLevel.length; i++){
            int curr = skillLevel[i];
            if(curr >= minLvl && curr <= maxLvl) tmp.add(curr);
        }
        return backtrack(tmp,new ArrayList<>(),this.minTeamMembers,0);
    }

    private int backtrack(List<Integer> qualified, List<Integer> tmp, int target, int head){
        int total = 0;
        if(head > qualified.size()) return 0;
        if(tmp.size() >= target) total++;


        for(int i = head; i < qualified.size(); i++){
            tmp.add(qualified.get(i));
            total += backtrack(qualified,tmp,target,i+1);
            tmp.remove(tmp.size()-1);
        }
        return total;
    }

}

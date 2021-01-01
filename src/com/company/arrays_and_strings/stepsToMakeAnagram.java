package com.company.arrays_and_strings;

import java.util.HashMap;

public class stepsToMakeAnagram {
    public int minSteps_1(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap();
        HashMap<Character, Integer> mapT = new HashMap();

        for(int i = 0; i < s.length(); i++){
            char currS = s.charAt(i);
            char currT = t.charAt(i);

            if(mapS.containsKey(currS)) mapS.put(currS,mapS.get(currS)+1);
            else mapS.put(currS,1);

            if(mapT.containsKey(currT)) mapT.put(currT,mapT.get(currT)+1);
            else mapT.put(currT,1);
        }

        int res = 0;
        for(char i : mapT.keySet()){
            if(mapS.containsKey(i)){
                int currS = mapS.get(i), currT = mapT.get(i);

                if(currT > currS) res += currT - currS;
            } else res += mapT.get(i);
        }

        return res;
    }

    
}

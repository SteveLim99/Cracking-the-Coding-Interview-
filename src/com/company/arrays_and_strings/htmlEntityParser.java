package com.company.arrays_and_strings;

import java.util.HashMap;

public class htmlEntityParser {
    public String entityParser_1(String text) {
        StringBuilder tmp = new StringBuilder();
        StringBuilder res = new StringBuilder();
        HashMap<String, String> entities = new HashMap();
        entities.put("&quot","\"");
        entities.put("&apos","\'");
        entities.put("&amp","&");
        entities.put("&gt",">");
        entities.put("&lt","<");
        entities.put("&frasl","/");

        boolean possible = false;
        for(int i = 0; i < text.length(); i++){
            char curr = text.charAt(i);

            if(curr == ';'){
                if(entities.containsKey(tmp.toString())) res.append(entities.get(tmp.toString()));
                else {
                    res.append(tmp.toString());
                    res.append(curr);
                }
                tmp = new StringBuilder();
                possible = false;
                continue;
            }

            if(curr == '&' || possible){
                if(!possible) possible = true;
                tmp.append(curr);
            }

            else res.append(curr);
        }

        return res.toString();
    }
}

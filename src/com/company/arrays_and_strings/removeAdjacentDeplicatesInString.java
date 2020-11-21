package com.company.arrays_and_strings;

public class removeAdjacentDeplicatesInString {
    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int count = 1;

        while(true){
            boolean noK = true;
            int tail = 0;
            count = 1;
            char curr = sb.charAt(0);

            for(int i = 1; i < sb.length(); i++){
                if(sb.charAt(i) != curr || count == k){
                    if(count == k){
                        noK = false;
                        sb.delete(tail,i);
                        i -= k;
                    }
                    curr = sb.charAt(i);
                    tail = i;
                    count = 1;
                }
                else count++;

            }

            if(noK) break;

        }

        while(count == k){
            sb.delete(sb.length()-k,sb.length());
            count -= k;
        }

        return sb.toString();
    }
}

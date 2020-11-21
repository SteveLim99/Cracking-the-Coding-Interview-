package com.company.arrays_and_strings;

public class stringCompress {
    public int compress(char[] chars) {
        int j, length = 0, count = 1, head = 0;
        char curr = chars[0];

        for(j = 1; j < chars.length; j++){
            if(chars[j] != curr){
                chars[head++] = curr;
                length++;
                if(count != 1){
                    String remainder = Integer.toString(count);
                    char[] tmp = (remainder).toCharArray();
                    for(char c : tmp){
                        chars[head++] = c;
                        length++;
                    }
                }
                curr = chars[j];
                count = 1;
            } else count++;
        }

        if (count != 0){
            chars[head++] = curr;
            length++;
            if(count != 1){
                String remainder = Integer.toString(count);
                char[] tmp = (remainder).toCharArray();
                for(char c : tmp){
                    chars[head++] = c;
                    length++;
                }
            }
        }

        return length;
    }
}

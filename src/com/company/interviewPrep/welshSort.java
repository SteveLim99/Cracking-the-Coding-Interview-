package com.company.interviewPrep;

import java.util.*;

public class welshSort {

    public static void main(String[] args){
        String[] words = new String[]{"ddr", "nah", "dea", "dd", "ngah", "ff"};
        List<String> ans = getRank(words);
        System.out.println(ans);
    }

    public static List<String> getRank(String[] words){
        String[] welsh = new String[]{"a", "b", "c", "ch", "d", "dd", "e", "f", "ff", "g", "ng", "h", "i", "l", "ll", "m", "n", "o", "p", "ph", "r", "rh", "s", "t", "th", "u", "w", "y"};
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        HashMap<String,Character> map = new HashMap<>();
        HashMap<String,String> wordMap = new HashMap<>();
        for(int i = 0; i < alpha.length; i++)
            map.put(welsh[i],alpha[i]);

        PriorityQueue<String> englishWords = new PriorityQueue<>();
        for(String word : words){
            if(word.length() > 1) {
                StringBuilder sb = new StringBuilder();
                for(int i = 1; i < word.length(); i++){
                    char head = word.charAt(i), tail = word.charAt(i-1);
                    boolean dual = false;

                    if(tail == 'f' && head == 'f'){
                        sb.append(map.get("ff"));
                        dual = true;
                    } else if (tail == 'c' && head == 'h'){
                        sb.append(map.get("ch"));
                        dual = true;
                    } else if (tail == 'd' && head == 'd'){
                        sb.append(map.get("dd"));
                        dual = true;
                    } else if (tail == 'n' && head == 'g'){
                        sb.append(map.get("ng"));
                        dual = true;
                    } else if (tail == 'l' && head == 'l'){
                        sb.append(map.get("ll"));
                        dual = true;
                    } else {
                        sb.append(map.get(Character.toString(tail)));
                        if(i == word.length()-1) sb.append(map.get(Character.toString(head)));
                    }

                    if(dual){
                        if(i != word.length()-1 && i+2 >= word.length()) sb.append(map.get(Character.toString(word.charAt(++i))));
                        else i++;
                    }
                }

                String englishWord = sb.toString();
                wordMap.put(englishWord,word);
                englishWords.offer(englishWord);
            }
            else {
                String englishWord = Character.toString(map.get(word));
                wordMap.put(englishWord,word);
                englishWords.offer(englishWord);
            }
        }

        List<String> res = new ArrayList<>();
        while(!englishWords.isEmpty())
            res.add(wordMap.get(englishWords.poll()));
        return res;
    }
}

package com.satyam.leetcode.contest.virtual1;

import java.util.HashMap;

public class CountValidOccurence {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        String whole = String.join("",chunks);
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map= new HashMap<>();
        for(int i = 0; i< whole.length(); i++){
            char curr = whole.charAt(i);
            if( isLowerCaseAlphabet(curr))
                sb.append(curr);
            else if(curr == '-'){
                if(i-1 >= 0 && i+1 < whole.length() &&
                        isLowerCaseAlphabet(whole.charAt(i-1)) &&
                        isLowerCaseAlphabet(whole.charAt(i+1))){
                    sb.append(curr);
                }
                else{
                    if(!sb.isEmpty()){
                        String word = sb.toString();
                        map.put(word,map.getOrDefault(word,0)+1);
                        sb.setLength(0);
                    }
                }
            }
            else{
                if(!sb.isEmpty()){
                    String word = sb.toString();
                    map.put(word,map.getOrDefault(word,0)+1);
                    sb.setLength(0);
                }
            }
        }

        if(!sb.isEmpty()){ //last word
            String word = sb.toString();
            map.put(word,map.getOrDefault(word,0)+1);
        }

        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++)
            res[i] = map.getOrDefault(queries[i],0);
        return res;
    }

    private boolean isLowerCaseAlphabet(char ch){
       return ch >= 'a' & ch <= 'z';
    }
}

package com.satyam.leetcode.interview150.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character,String> charStrMap = new HashMap<>();
        Map<String,Character> strCharMap = new HashMap<>();
        String[] stringArr = s.split("\\s+");

        if(pattern.length() != stringArr.length)
            return false;

        for(int i = 0; i < pattern.length(); i++){
            char currChar = pattern.charAt(i);
            String currString = stringArr[i];
            //if both unseen add both mappings
            if(!charStrMap.containsKey(currChar) && !strCharMap.containsKey(currString)){
                charStrMap.put(currChar,currString);
                strCharMap.put(currString,currChar);
            }
            //if both seen verify both mappings
            else if(charStrMap.containsKey(currChar) && strCharMap.containsKey(currString)){
                if(currChar != strCharMap.get(currString) ||
                !currString.equals(charStrMap.get(currChar)))
                    return false;
            }
            else
                return false;
        }
        return true;
    }
}

package com.satyam.leetcode.interview150.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWithoutRepeat {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;
        int L = 0, maxLen = -1;
        Set<Character> set = new HashSet<>();
        for(int R = 0; R < s.length(); R++){
            char curr = s.charAt(R);
            while(set.contains(curr)){
                set.remove(s.charAt(L));
                L++;
            }
            maxLen = Math.max(maxLen,R-L+1);
            set.add(curr);
        }
        return maxLen;
    }
}

package com.satyam.leetcode.interview150.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubString {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if (s == null || s.isEmpty() || words.length == 0)
            return ans;

        int wordLen = words[0].length();
        int wordCount = words.length;

        Map<String, Integer> target = new HashMap<>();

        for (String w : words)
            target.put(w, target.getOrDefault(w, 0) + 1);

        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int matched = 0;

            Map<String, Integer> window = new HashMap<>();

            for (int right = offset;
                 right + wordLen <= s.length();
                 right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (!target.containsKey(word)) {
                    window.clear();
                    matched = 0;
                    left = right + wordLen;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                matched++;

                while (window.get(word) > target.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    matched--;
                }

                if (matched == wordCount) {
                    ans.add(left);
                    String leftWord = s.substring(left, left + wordLen);
                    window.put(leftWord, window.get(leftWord) - 1);
                    left += wordLen;
                    matched--;
                }
            }
        }
        return ans;
    }
}

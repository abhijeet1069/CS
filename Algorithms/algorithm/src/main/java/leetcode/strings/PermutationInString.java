package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class PermutationInString {

    public static List<String> getPermutations(String str) {
        List<String> result = new ArrayList<>();
        permuteHelper(str.toCharArray(), 0, result);
        return result;
    }

    private static void permuteHelper(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            permuteHelper(chars, index + 1, result);
            swap(chars, i, index); // Backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static boolean checkInclusion(String s1, String s2) {
        List<String> permutations = getPermutations(s1);
        for(String str : permutations){
            if(s2.contains(str))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidboaoo";
        //System.out.println(checkInclusion(s1,s2));

       // String s2 = "eidbaooo";
        System.out.println(s1.charAt(-1));
    }
}

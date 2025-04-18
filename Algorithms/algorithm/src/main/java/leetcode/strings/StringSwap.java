package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class StringSwap {
    public static boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if(s1.equalsIgnoreCase(s2))
            return true;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i))
                list.add(i);
        }
        if(list.size() != 2) //there needs to be only 2 points of diff
            return false;
        int left = list.get(0);
        int right = list.get(1);

        StringBuilder sb = new StringBuilder(s1);
        char temp = sb.charAt(left);
        sb.setCharAt(left, sb.charAt(right));
        sb.setCharAt(right, temp);
        return s2.equalsIgnoreCase(sb.toString());
    }

    public static void main(String[] args) {
        String s1 = "kelb", s2 = "kelb";
        System.out.println(areAlmostEqual(s1,s2));
    }
}

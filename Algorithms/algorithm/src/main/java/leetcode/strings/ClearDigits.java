package leetcode.strings;

import java.util.Stack;

/**
 * You are given a string s.
 * Your task is to remove all digits by doing this operation repeatedly:
 * Delete the first digit and the closest non-digit character to its left.
 * Return the resulting string after removing all digits.
 *<p>
 * Input: s = "cb34"
 * Output: ""
 * Explanation:
 * First, we apply the operation on s[2], and s becomes "c4".
 * Then we apply the operation on s[1], and s becomes "".
 * </p>
 * Note : The input is generated such that it is possible to delete all digits.
 * So inputs like 1234 is not allowed
 *
 * For finding closest non-digit to the left stack was used.
 * */

public class ClearDigits {

    public static String clearDigits(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder("");
        for(int i = 0;i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)))
                stack.pop();
            else
                stack.push(s.charAt(i));
        }
        while(!stack.isEmpty())
            res.insert(0,stack.pop());

        return res.toString();
    }

    public static void main(String[] args) {
        String str = "abc12";
        System.out.println(clearDigits(str));
    }
}

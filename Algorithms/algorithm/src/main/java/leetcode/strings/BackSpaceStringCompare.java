package leetcode.strings;

import java.util.Stack;

public class BackSpaceStringCompare {

    private static String removeBackpace(String str){
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '#') {
                    try {
                        stack.pop();
                    }
                    catch(Exception ignored){}
                }
                else
                    stack.push(str.charAt(i));
            }
        while(!stack.isEmpty())
            res.insert(0,stack.pop());
        return res.toString();
    }

    public static boolean backspaceCompare(String s, String t) {
        String t1 = removeBackpace(s);
        String t2 = removeBackpace(t);
        return t1.equals(t2);
    }

    public static void main(String[] args) {
        String s1 = "a##c";
        String s2 = "#a#c";
        System.out.println(backspaceCompare(s1,s2));
    }
}

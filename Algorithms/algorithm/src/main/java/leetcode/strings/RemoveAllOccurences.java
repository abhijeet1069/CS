package leetcode.strings;

public class RemoveAllOccurences {

    public static String removeOccurrences(String s, String part) {
        while(s.contains(part))
            s = s.replace(part,"");
        return s;
    }

    public static void main(String[] args) {
        String str = "aabababa", part = "aba";
        System.out.println(removeOccurrences(str,part));
    }
}

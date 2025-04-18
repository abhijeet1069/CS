package leetcode.strings;

public class ReverseWords {

    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i>= 0; i--){
            sb.append(arr[i]).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "   hello   world  ";
        System.out.println(reverseWords(str));
    }
}

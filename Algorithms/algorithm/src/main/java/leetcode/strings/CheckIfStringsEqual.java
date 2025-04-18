package leetcode.strings;

public class CheckIfStringsEqual {

    public static boolean canBeEqual(String s1, String s2) {
        int[][] store = new int[2][26]; //2 arrays, first for even places other for odd places
        // Even places increment their position, even places decrement their position
        for(int i = 0; i < s1.length(); i++){
            store[i&1][s1.charAt(i)-'a']++;
            store[i&1][s2.charAt(i)-'a']--; //if s1 and s2 have both same length
        }

        for (int[] array : store) {
            for (int num : array) {
                if (num != 0)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(canBeEqual("bbfp","fbbp"));
        System.out.println(canBeEqual("abcd","dacb"));
    }
}
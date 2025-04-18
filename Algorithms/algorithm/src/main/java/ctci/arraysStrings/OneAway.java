package ctci.arraysStrings;

import java.util.HashMap;

public class OneAway {

    public static boolean isOneAway(String str1, String str2){
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < str1.length(); i++)
            map.put(str1.charAt(i),map.getOrDefault(str1.charAt(i),0)+1);
        for(int i = 0; i < str2.length(); i++)
            map.put(str2.charAt(i),map.getOrDefault(str2.charAt(i),1)-1);
        int count = 0;
        for(char ch : map.keySet())
            count += map.get(ch);
        return count<1;
    }

    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "bake";
        System.out.println(isOneAway(str1,str2));
    }
}

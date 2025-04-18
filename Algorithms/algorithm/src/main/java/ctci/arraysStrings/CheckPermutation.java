package ctci.arraysStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

    public static Map<Character, Integer> getCountMap(String str){
        HashMap<Character,Integer> map = new HashMap<>(256);
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        return map;
    }

    public static boolean isPermutation(String str1, String str2){
        Map<Character,Integer> map1 = getCountMap(str1);
        Map<Character,Integer> map2 = getCountMap(str2);
        for(char ch : map1.keySet()){
            Integer countMap2 = map2.get(ch);
            if(countMap2 == null)
                return false;
            if(!countMap2.equals(map1.get(ch)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "bbbbc";
        String str2 = "bcbbb";
        System.out.println(isPermutation(str1,str2));
    }
}

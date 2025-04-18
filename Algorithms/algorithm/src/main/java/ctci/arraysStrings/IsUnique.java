package ctci.arraysStrings;

import java.util.HashMap;

public class IsUnique {

    public static boolean isUnique(String str){
        HashMap<Character,Integer> map = new HashMap<>(256);
        str = str.toLowerCase();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch : map.keySet()){
            if(map.get(ch) > 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "copy hill";
        System.out.println(isUnique(str));
    }
}

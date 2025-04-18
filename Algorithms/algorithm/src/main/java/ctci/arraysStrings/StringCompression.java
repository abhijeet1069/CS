package ctci.arraysStrings;

import java.util.HashMap;

public class StringCompression {

    public static String compressString(String str){
        str = str.toLowerCase();
        HashMap<Character,Integer> map = new HashMap<>(26);
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : map.keySet()){
            sb.append(ch).append(map.get(ch));
        }
        String res = sb.toString();
        if(res.length() < str.length())
            return res;
        else
            return str;
    }

    public static void main(String[] args) {
        String str = "string would not become smaller than the original string";
        System.out.println(compressString(str));
    }
}

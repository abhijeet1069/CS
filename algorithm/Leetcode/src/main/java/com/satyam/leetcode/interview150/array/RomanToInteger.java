//package com.satyam.leetcode.interview150.array;
//
//import java.util.Map;
//import java.util.Set;
//
//public class RomanToInteger {
//    public int romanToInt(String s) {
//        Map<Character,Integer> map = Map.of(
//                'I',1,
//                'V',5,
//                'X',10,
//                'L',50,
//                'C',100,
//                'D',500,
//                'M',1000
//        );
//        Set<String> set = Set.of("IV","IX","XL","XC","CD","CM");
//
//        int sum = map.get(s.charAt(s.length()-1));
//        for(int i = s.length()-2; i >= 0; i--){
//            String temp = s.charAt(i)+""+s.charAt(i+1);
//            if(set.contains(temp))
//                sum -= map.get(s.charAt(i));
//            else
//                sum += map.get(s.charAt(i));
//        }
//        return sum;
//    }
//}

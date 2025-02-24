package com.scalar.lld1.class3;

import java.util.*;

public class AnagramGrouper {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramsList = new ArrayList<>();
        Map<String, List<String>> hashMap = new LinkedHashMap<>();
        if(strs == null || strs.length == 0)
        {
            return anagramsList;
        }
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            hashMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        anagramsList.addAll(hashMap.values());


        return anagramsList;
    }

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan"};
        List<List<String>> result = groupAnagrams(strs);

        for(List<String> ans:result){
            System.out.println(ans);
        }
    }
}
package leetcode2.p49;

import java.util.*;

public class Solution {

    /**
     * 同位词，按字母计数，拼装成“a1p2”形式，作为map的键
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : strs) {
            //26位的数组计数
            int[] bit = new int[26];
            for (int i = 0; i < word.length(); i++) {
                bit[word.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < bit.length; j++) {
                if (bit[j] > 0) {
                    //字母
                    sb.append(j + 'a');
                    //个数
                    sb.append(bit[j]);
                }
            }
            List<String> value = map.getOrDefault(sb.toString(), new ArrayList<>());
            value.add(word);
            map.put(sb.toString(), value);
        }
        return new ArrayList<>(map.values());
    }

}

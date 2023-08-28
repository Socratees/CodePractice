package leetcode2.p30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int value = wordMap.getOrDefault(words[i], 0);
            wordMap.put(words[i], value + 1);
        }
        int lenSum = words.length * words[0].length();
        int wordLength = words[0].length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= s.length() - lenSum; i++) {
            if (!wordMap.containsKey(s.substring(i, i + wordLength))) {
                continue;
            }
            Map<String, Integer> tmp = new HashMap<>(wordMap);
            Map<String, Integer> countMap = wordCount(s, i, i + lenSum - 1, wordLength, tmp);
            if (checkCountArr(countMap)) {
                res.add(i);
            }

        }
        return res;
    }

    public boolean checkCountArr(Map<String, Integer> wordMap) {
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    public Map<String, Integer> wordCount(String s, int start, int end, int wordLength, Map<String, Integer> wordMap) {
        int pointer = start;
        while (pointer <= end) {
            String w = s.substring(pointer, pointer + wordLength);
            if (wordMap.containsKey(w)) {
                wordMap.put(w, wordMap.get(w) - 1);
            }
            pointer += wordLength;
        }
        return wordMap;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "a";
        String[] words = {"a"};
        System.out.println(solution.findSubstring(s, words));
    }
}

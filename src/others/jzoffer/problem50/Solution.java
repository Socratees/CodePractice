package others.jzoffer.problem50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
//    public char firstUniqChar(String s) {
//        if (s.length() == 0) {
//            return ' ';
//        }
//        List<Character> list = new ArrayList<>();
//        HashSet<Character> set = new HashSet<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (!list.isEmpty() && list.contains(s.charAt(i))) {
//                list.remove((Character) s.charAt(i));
//            } else if (!set.contains(s.charAt(i))) {
//                list.add(s.charAt(i));
//            }
//            set.add(s.charAt(i));
//        }
//        return (list.size() > 0) ? list.get(0) : ' ';
//    }

    public char firstUniqChar(String s) {
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s.length();i++){
            if(times[s.charAt(i)-'a']==1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("abaccdeff"));
    }
}

package leetcode.leetcode347;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        for(int n: nums){
            if(hashtable.containsKey(n)){
                int v = hashtable.get(n);
                v += 1;
                hashtable.put(n, v);
            }
            else{
                hashtable.put(n,1);
            }
        }
        List<Integer> v = new ArrayList<Integer>(hashtable.keySet());
        Collections.sort(v, new Comparator<Integer>() {
            public int compare(Integer arg0, Integer arg1) {
                return hashtable.get(arg1) - hashtable.get(arg0);
            }
        });
        System.out.println(v);
        for (int i = 0; i < result.length; i++) {
            result[i] = v.get(i);
        }

//
//        class Pair {
//            private Integer first;
//            private Integer second;
//
//            Pair(Integer first, Integer second) {
//                this.first = first;
//                this.second = second;
//            }
//        }
//
//        List<Integer> keys = hashtable.entrySet()
//                .stream()
//                .map(e -> new Pair(e.getValue(), e.getKey()))
//                .sorted((a, b) -> b.first - a.first)
//                .limit(k)
//        .map(p-> p.second)
//        .collect(Collectors.toList());
//        for (int i = 0; i < keys.size(); i++) {
//            result[i] = keys.get(i);
//        }

        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.topKFrequent(new int[]{1,1,1,3,2,3,4}, 2);
    }
}

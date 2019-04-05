package leetcode.leetcode697;

import java.util.*;

public class leetcode697 {
    public static int findShortestSubArray(int[] nums) {

        int min = 0;
        List<Integer> commonList = getCommonNumber(nums);
        
        int l = 0, r = 0;
        for(int i = 0; i < commonList.size(); i++){
            for(int j = 0; j < nums.length; j++){
                if(nums[j] == commonList.get(i)){
                    l = j;
                    break;
                }
            }

            for(int k = nums.length - 1; k >= 0; k--){
                if(nums[k] == commonList.get(i)){
                    r = k;
                    break;
                }
            }

            if(i == 0){
                min = r - l + 1;
            }else{
                min = Math.min(min, r - l + 1);
            }

        }
        System.out.println(min);
        return min;
    }

    //获得众数数组
    public static List<Integer> getCommonNumber(int[] nums){
        List<Integer> list = new ArrayList<>();
        Map<Integer,Integer> input = new HashMap<Integer, Integer>();
        for(int e:nums){
            if(input.containsKey(e)){
                input.put(e, input.get(e) + 1);
            }else{
                input.put(e, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(input.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        list.add(entries.get(0).getKey());
        for(int i=1;i<entries.size();i++){
            if(entries.get(i).getValue().equals(entries.get(0).getValue())){
                list.add(entries.get(i).getKey());
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        findShortestSubArray(nums);
    }
}

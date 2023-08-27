package leetcode2.p274;

public class Solution {
    /**
     * 计数排序，用一个数组记录引用i次的文章有多少篇
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int[] counter = new int[citations.length + 1];
        int len = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] > len) {
                counter[len]++;
            } else {
                counter[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = counter.length - 1; i >= 0; i--) {
            sum += counter[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3, 0, 6, 1, 5};
        int[] arr2 = new int[]{1, 1};
        System.out.println(solution.hIndex(arr2));
    }
}

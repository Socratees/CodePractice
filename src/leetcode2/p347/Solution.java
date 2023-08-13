package leetcode2.p347;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int n : nums) {
            if (frequency.containsKey(n)) {
                frequency.put(n, frequency.get(n) + 1);
            } else {
                frequency.put(n, 1);
            }
        }

        int[] keys = new int[frequency.keySet().size()];
        int keyIndex = 0;
        Iterator<Integer> iterator = frequency.keySet().iterator();
        while (iterator.hasNext()) {
            keys[keyIndex] = iterator.next();
            keyIndex++;
        }

        int left = 0, right = keys.length - 1;

        while (true) {
            int pivot = partition(frequency, keys, left, right);
            if (pivot == k - 1) {
                int[] res = new int[k];
                for (int i = 0; i < k; i++) {
                    res[i] = keys[i];
                }
                return res;
            } else if (pivot > k - 1) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
    }


    public int partition(Map<Integer, Integer> frequency, int[] nums, int left, int right) {
        int pivot = left;
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && frequency.get(nums[le]) > frequency.get(nums[pivot])) {
                le++;
            }
            while (le <= ge && frequency.get(nums[ge]) < frequency.get(nums[pivot])) {
                ge--;
            }
            if (le >= ge) {
                break;
            }
            swap(nums, le, ge);
            le++;
            ge--;
        }
        swap(nums, left, ge);
        return ge;
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

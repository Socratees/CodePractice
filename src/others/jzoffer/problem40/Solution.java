package others.jzoffer.problem40;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

//    public int[] getLeastNumbers(int[] arr, int k) {
////        Arrays.sort(arr);
//        if (k == 0 || arr.length == 0) {
//            return new int[0];
//        }
//        int start = 0;
//        int end = arr.length - 1;
//        int index = partition(arr, start, end);
//        while (index != k - 1) {
//            index = partition(arr, start, end);
//            if (index > k - 1) {
//                end = index - 1;
//            } else {
//                start = index + 1;
//            }
//        }
//        int[] result = new int[k];
//        System.arraycopy(arr, 0, result, 0, k);
//        return result;
//    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        if (arr.length <= k) {
            return arr;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                queue.add(arr[i]);
            } else {
                if (!queue.isEmpty() && arr[i] < queue.peek()) {
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        int[] result = new int[k];
        for(int i=0;i<k;i++){
            if(!queue.isEmpty()){
                result[i] = queue.poll();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.getLeastNumbers(new int[]{0, 0, 1, 3, 4, 5, 0, 7, 6, 7}, 9);
        System.out.println(Arrays.toString(result));
    }
}

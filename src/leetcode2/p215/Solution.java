package leetcode2.p215;

import java.util.Random;

public class Solution {
    /**
     * 建立一个大根堆，做k−1次删除操作后堆顶元素就是要找的答案
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            //堆的删除操作，交换堆顶和最后一个元素，然后heapSize减1
            swap(nums, i, 0);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildHeap(int[] nums, int heapSize) {
        //从非叶子节点开始
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int index, int heapSize) {
        int l = index * 2 + 1;
        int r = index * 2 + 2;
        int largest = index;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != index) {
            swap(nums, index, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public int findKthLargest2(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == nums.length - k) {
                return nums[pivot];
            } else if (pivot > nums.length - k) {
                right = pivot-1;
            }else {
                left = pivot+1;
            }
        }
    }

    private final static Random random = new Random(System.currentTimeMillis());

    public int partition(int[] nums, int left, int right) {
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int le = left + 1;
        int ge = right;
        while (true) {
            while (le <= ge && nums[le] < pivot) {
                le++;
            }
            while (le <= ge && nums[ge] > pivot) {
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
}

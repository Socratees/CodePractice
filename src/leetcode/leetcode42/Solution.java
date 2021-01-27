package leetcode.leetcode42;

public class Solution {
    //接雨水，用两个数组存储当前元素左边的maxHeight和右边的maxHeight，取二者的最小值，减去当前高度，即为接水的高度
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int[] leftMaxHeight = new int[height.length];
        int[] rightMaxHeight = new int[height.length];
        for (int i = 0, j = height.length - 1; i < height.length; i++, j--) {
            if (i == 0) {
                leftMaxHeight[i] = height[i];
                rightMaxHeight[j] = height[j];
            } else {
                leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i]);
                rightMaxHeight[j] = Math.max(rightMaxHeight[j + 1], height[j]);
            }
        }
        int sum=0;
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(leftMaxHeight[i],rightMaxHeight[i]) - height[i];
        }
        return sum;
    }
}

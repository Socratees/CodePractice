package leetcode2.p42;

public class Solution {

    /**
     * 正向和反向遍历，得到leftMax和rightMax数组，每个位置能接的雨水就是 Math.min(leftMax[i], rightMax[i]) - height[i]
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int left = 0;
        for (int i = 0; i < height.length; i++) {
            left = Math.max(left, height[i]);
            leftMax[i] = left;
        }

        int right = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            right = Math.max(right, height[i]);
            rightMax[i] = right;
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] < Math.min(leftMax[i], rightMax[i])) {
                sum += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
        }
        return sum;
    }
}

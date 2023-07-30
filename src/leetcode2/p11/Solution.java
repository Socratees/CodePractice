package leetcode2.p11;

public class Solution {
    /**
     * S(i,j)=min(h[i],h[j])×(j−i)
     * 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度 −1变短：
     * <p>
     * 若向内 移动短板 ，水槽的短板 min(h[i],h[j])可能变大，因此下个水槽的面积 可能增大 。
     * 若向内 移动长板 ，水槽的短板 min(h[i],h[j])不变或变小，因此下个水槽的面积 一定变小 。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

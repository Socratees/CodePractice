package leetcode.leetcode559;

public class leetcode559 {
    public int maxDepth(Node root) {
        int max = 0;
        if (root != null) {
            if (root.children != null) {
                for (int i = 0; i < root.children.size(); i++) {
                    max = Math.max(max, maxDepth(root.children.get(i)));
                }
                return ++max;
            }
        }
        return max;
    }
}

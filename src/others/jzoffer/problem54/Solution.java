package others.jzoffer.problem54;

public class Solution {
    int current = 1;
    int result = 0;

    public int kthLargest(TreeNode root, int k) {
        preOrder(root,k);
        return result;
    }

    public void preOrder(TreeNode root, int k) {
        if (root != null) {
            preOrder(root.right, k);

            if (k == current) {
                result = root.val;
            }
            current++;
            preOrder(root.left, k);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(4);
        node1.left.right = new TreeNode(2);
        System.out.println(solution.kthLargest(node1, 1));
    }
}

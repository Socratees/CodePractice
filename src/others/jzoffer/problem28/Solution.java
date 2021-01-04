package others.jzoffer.problem28;

public class Solution {
    public boolean isSymmetrical(TreeNode root) {
        String s1 = preOrder(root, "");
        String s2 = specialOrder(root, "");
        System.out.println(s1);
        System.out.println(s2);
        return s1.equals(s2);
    }

    public String preOrder(TreeNode root, String s) {
        if (root == null) {
            s += "null";
        } else {
            s += String.valueOf(root.value);
            s = preOrder(root.left, s);
            s = preOrder(root.right, s);
        }
        return s;
    }

    public String specialOrder(TreeNode root, String s) {
        if (root == null) {
            s += "null";
        } else {
            s += String.valueOf(root.value);
            s = specialOrder(root.right, s);
            s = specialOrder(root.left, s);
        }
        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        solution.isSymmetrical(node1);
    }
}

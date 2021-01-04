package others.jzoffer.problem26;

public class Solution {
    public boolean hasSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if(root1.value == root2.value){
                result = doesTree1HasTree2(root1, root2);
            }
            if(!result){
                result = hasSubTree(root1.left, root2);
            }
            if(!result){
                result = hasSubTree(root1.right, root2);
            }
        }
        return result;
    }

    public boolean doesTree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.value != root2.value) {
            return false;
        }

        return doesTree1HasTree2(root1.left, root2.left) && doesTree1HasTree2(root1.right, root2.right);
    }
}

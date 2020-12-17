package others.jzoffer.construct_tree;

public class Solution {
    public Node Construct(int[] preorder, int[] inorder, int length) {
        if (length <= 0 || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        int rootValue = preorder[0];
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                Node root = new Node();
                root.value = rootValue;
                int leftLength = i;
                int rightLength = length - i - 1;
                int[] leftPreorder = new int[leftLength];
                int[] leftInorder = new int[leftLength];
                int[] rightPreorder = new int[rightLength];
                int[] rightInorder = new int[rightLength];
                for (int j = 0; j < leftLength; j++) {
                    leftInorder[j] = inorder[j];
                    leftPreorder[j] = preorder[j + 1];
                }
                for (int k = 0; k < rightLength; k++) {
                    rightInorder[k] = inorder[k + leftLength + 1];
                    rightPreorder[k] = preorder[k + leftLength + 1];
                }
                root.left = Construct(leftPreorder, leftInorder, leftLength);
                root.right = Construct(rightPreorder, rightInorder, rightLength);
                return root;
            }
        }

        return Construct(preorder, inorder, 0);
    }

    public void PreOrder(Node root){
         if(root!=null){
            System.out.println(root.value);
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        Node node = solution.Construct(new int[]{1,2,4,7,3,5,6,8}, new int[]{4,7,2,1,5,3,8,6}, 8);
        solution.PreOrder(node);
    }

//    public Node ConstructCore(int[] preorder, int[] inorder, int startPreorder, int endPreorder, int startInorder, int endInorder) {
//        int rootValue = preorder[0];
//        Node root = new Node();
//        root.value = rootValue;
//        root.left = null;
//        root.right = null;
//
//        if (startPreorder == endPreorder) {
//            if (startInorder == endInorder &&) {
//
//            }
//        }
//
//    }


}

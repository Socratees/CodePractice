package leetcode.leetcode589;

import java.util.ArrayList;
import java.util.List;

public class leetcode589 {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root != null) {
            list.add(root.val);
            if (root.children != null) {
                for (int i = 0; i < root.children.size(); i++) {
                    list.addAll(preorder(root.children.get(i)));
                }
            }
            return list;
        }
        return new ArrayList<>();
    }
}

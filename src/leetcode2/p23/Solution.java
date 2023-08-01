package leetcode2.p23;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0){
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        if (start > end) {
            return null;
        } else {
            int mid = (start + end) / 2;
            return mergeTwoNodes(merge(lists, start, mid), merge(lists, mid + 1, end));
        }
    }

    public ListNode mergeTwoNodes(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
                pre = pre.next;
            } else {
                pre.next = right;
                right = right.next;
                pre = pre.next;
            }
        }
        pre.next = left == null ? right : left;
        return dummy.next;
    }
}

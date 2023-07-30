package leetcode2.p148;

public class Solution {
    /**
     * 归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode rightTail = head.next, leftTail = head;
        while (rightTail != null && rightTail.next != null) {
            rightTail = rightTail.next.next;
            leftTail = leftTail.next;
        }
        ListNode rightHead = leftTail.next;

        leftTail.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return merge(left, right);

    }

    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left!=null){
            cur.next = left;
        } else if (right!=null) {
            cur.next = right;
        }
        return dummy.next;
    }

}

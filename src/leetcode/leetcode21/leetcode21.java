package leetcode.leetcode21;

public class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode first = new ListNode(0);
        ListNode p = first;
        while(l1!=null && l2!=null){
            if(l2.val <= l1.val){
                ListNode node = new ListNode(l2.val);
                p.next = node;
                p = p.next;
                l2 = l2.next;
            }
            else{
                ListNode node = new ListNode(l1.val);
                p.next = node;
                p = p.next;
                l1 = l1.next;
            }

        }

        if(l1 == null && l2 != null){
            p.next = l2;
        }
        else if(l2 == null && l1!=null){
            p.next = l1;
        }

        return first.next;
    }
}

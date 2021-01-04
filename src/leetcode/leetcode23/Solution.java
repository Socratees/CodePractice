package leetcode.leetcode23;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //合并K个升序链表
    //递归法
    public ListNode mergeKLists(ListNode[] lists) {
        boolean allIsNull = true;
        ListNode root = null;
        int minIndex = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                allIsNull = false;
                if (root == null) {
                    root = lists[i];
                    minIndex = i;
                } else if (lists[i].val < root.val) {
                    root = lists[i];
                    minIndex = i;
                }

            }
        }

        if (allIsNull) {
            return null;
        }

        lists[minIndex] = lists[minIndex].next;

        root.next = mergeKLists(lists);
        return root;
    }

    //使用最小堆优先队列
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode current = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode node:lists){
            if(node!=null){
                queue.add(node);
            }
        }
        while (!queue.isEmpty()){
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;
            if(node.next!=null){
                queue.add(node.next);
            }
        }

        return head.next;
    }
}

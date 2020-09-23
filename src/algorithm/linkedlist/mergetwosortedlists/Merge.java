package algorithm.linkedlist.mergetwosortedlists;

import algorithm.linkedlist.LinkedListUtils;
import algorithm.linkedlist.model.ListNode;

public class Merge {
    public static void main(String[] args) {
        ListNode node3 = new ListNode(5, null);
        ListNode node2 = new ListNode(4, node3);
        ListNode l1 = new ListNode(1, node2);

        ListNode n4 = new ListNode(6, null);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode l2 = new ListNode(1, n2);

        //        LinkedListUtils.printLinkedList(merge(l1, l2));
//        LinkedListUtils.printLinkedList(mergeTwoLists_21(l1, l2));
        LinkedListUtils.printLinkedList(mergeTwoLists2_21(l1, l2));
    }

    private static ListNode mergeTwoLists2_21(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists2_21(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2_21(l1, l2.next);
            return l2;
        }
    }

    private static ListNode mergeTwoLists_21(ListNode l1, ListNode l2) {
        //哨兵节点，方便链表的输出
        ListNode preHead = new ListNode(-1, null);

        ListNode pre = preHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }

        //l1或者l2肯定有一个是null，那么另外那个就直接拼接到末尾即可
        pre.next = l1 == null ? l2 : l1;

        return preHead.next;
    }

    /**
     * 想法:
     * 两个链表头部较小的一个与剩下元素的 merge 操作结果合并
     * <p>
     * 算法:
     * 我们直接将以上递归过程建模，首先考虑边界情况。
     * 特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2
     * 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by
     * -leetcode/
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }
}

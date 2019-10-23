package algorithm.linkedlist.findmiddlenode;

import algorithm.linkedlist.LinkedListUtils;
import algorithm.linkedlist.model.ListNode;

public class MiddleNode {
    public static void main(String[] args) {
        ListNode node9 = new ListNode(9, null);
        ListNode node8 = new ListNode(8, node9);
        ListNode node7 = new ListNode(7, node8);
        ListNode node6 = new ListNode(6, node7);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        System.out.println("链表");
        LinkedListUtils.printLinkedList(head);
        System.out.println();
        System.out.println("中点：" + findMiddle(head).val);
    }

    /**
     * 使用快慢指针
     */
    private static ListNode findMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

}

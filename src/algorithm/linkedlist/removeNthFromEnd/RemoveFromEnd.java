package algorithm.linkedlist.removeNthFromEnd;

import algorithm.linkedlist.LinkedListUtils;
import algorithm.linkedlist.model.ListNode;

public class RemoveFromEnd {

    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        System.out.println("删除前");
        LinkedListUtils.printLinkedList(head);

        System.out.println();
        System.out.println("删除从后往前第3位后");
        LinkedListUtils.printLinkedList(removeNthFromEnd(head, 3));
    }

    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = dummy;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        ListNode second = dummy;
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}

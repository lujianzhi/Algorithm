package algorithm.linkedlist;

import algorithm.linkedlist.model.ListNode;

public class Main {

    public static void main(String[] args) {
//        reverseLinkedList(getListNode());

        swapNode(getListNode());
    }

    /**
     * 1-2-3-4-5
     * 2-1-4-3-5
     */
    private static void swapNode(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while (cur != null && cur.next != null) {
            ListNode temp = cur.next.next;

            ListNode next2 = cur.next;
            cur.next = next;
            next = cur;
            next.next = next2;

            cur = temp;
        }

        printListNode(next);
    }

    /**
     * 1-2-3-4-5
     * 5-4-3-2-1
     */
    private static void reverseLinkedList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        printListNode(pre);
    }

    private static void printListNode(ListNode head) {
        System.out.println("开始遍历");
        while (head != null) {
            System.out.println(String.valueOf(head.value));
            head = head.next;
        }
        System.out.println("遍历结束");
    }

    private static ListNode getListNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        return node1;
    }
}

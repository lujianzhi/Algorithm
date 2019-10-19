package algorithm.linkedlist;

import algorithm.linkedlist.model.ListNode;

public class LinkedListUtils {

    public static void printLinkedList(ListNode linkedList) {
        while (linkedList != null) {
            System.out.print(linkedList.val + "  ");
            linkedList = linkedList.next;
        }
    }
}

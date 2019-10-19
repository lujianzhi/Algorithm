package datastructure.linkedlist.revert;

import datastructure.linkedlist.ListNode;

public class RevertLinkedList {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        System.out.println("反转前");
        printLinkedList(head);

        System.out.println();
        System.out.println("开始反转");
        ListNode reversedHead = reverseList(head);

        System.out.println("反转后");
        printLinkedList(reversedHead);
    }

    /**
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。
     * 不要忘记在最后返回新的头引用！
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode tempNext = current.next;
            current.next = pre;
            pre = current;
            current = tempNext;
        }
        return pre;
    }

    private static void printLinkedList(ListNode linkedList) {
        while (linkedList != null) {
            System.out.print(linkedList.val + "  ");
            linkedList = linkedList.next;
        }
    }
}

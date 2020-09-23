package algorithm.linkedlist.removeNthFromEnd;

import algorithm.linkedlist.LinkedListUtils;
import algorithm.linkedlist.model.ListNode;

public class RemoveFromEnd {

    public static void main(String[] args) {
        //        ListNode node5 = new ListNode(5, null);
        //        ListNode node4 = new ListNode(4, node5);
        //        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, null);
        ListNode head = new ListNode(1, node2);

        System.out.println("删除前");
        LinkedListUtils.printLinkedList(head);

        System.out.println();
        System.out.println("删除从后往前第3位后");
        LinkedListUtils.printLinkedList(removeNthFromEnd(head, 2));
        //        LinkedListUtils.printLinkedList(removeNNode_19(head, 2));
    }

    private static ListNode removeNNode_19(ListNode head, int n) {
        //这里fast还是从head开始，并没有牵扯到哨兵节点
        ListNode fast = head;
        //fast节点先走N步
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //创建一个哨兵节点，指向头节点
        ListNode newNode = new ListNode(-1, head);
        //slow节点等fast走完了再开始走
        ListNode slow = newNode;
        //fast如果还没走到链表末尾，那么就和slow一起走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //fast走到结尾了，那么slow就把原来的next指针指向下下个
        slow.next = slow.next.next;

        //通过哨兵节点返回真正的头结点
        return newNode.next;
    }

    /**
     * 首先我们将添加一个哑结点dummy作为辅助，该结点位于列表头部。哑结点用来简化某些极端情况，
     * 例如列表中只含有一个结点，或需要删除列表的头部。
     * <p>
     * 我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。
     * 现在，这两个指针被 n个结点分开。
     * 我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点。
     * 此时第二个指针将指向从最后一个结点数起的第 nn 个结点。我们重新链接第二个指针所引用的结点的 next
     * 指针指向该结点的下下个结点。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shan-chu-lian-biao-de-dao-shu-di
     * -nge-jie-dian-by-l/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
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

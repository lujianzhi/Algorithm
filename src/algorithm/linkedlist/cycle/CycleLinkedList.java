package algorithm.linkedlist.cycle;

import java.util.HashSet;
import java.util.Set;

import algorithm.linkedlist.model.ListNode;

public class CycleLinkedList {
    public static void main(String[] args) {
        slowAndFast();
        System.out.println();
        System.out.println();
        System.out.println();
        hashSet();
    }

    /**
     * 哈希表解法
     */
    private static void hashSet() {
        System.out.println("hashSet解法");
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        node5.next = node2;
        System.out.println("源链表有环");
        System.out.println("检测结果：");
        System.out.println(hasCycleHashSet(head));

        node5.next = null;
        System.out.println("源链表无环");
        System.out.println("检测结果：");
        System.out.println(hasCycleHashSet(head));
    }

    /**
     * 我们可以通过检查一个结点此前是否被访问过来判断链表是否为环形链表。常用的方法是使用哈希表。
     * <p>
     * 我们遍历所有结点并在哈希表中存储每个结点的引用（或内存地址）。
     * 如果当前结点为空结点 null（即已检测到链表尾部的下一个结点），那么我们已经遍历完整个链表，并且该链表不是环形链表。
     * 如果当前结点的引用已经存在于哈希表中，那么返回 true（即该链表为环形链表）。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static boolean hasCycleHashSet(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针解法
     */
    private static void slowAndFast() {
        System.out.println("快慢指针解法");
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode head = new ListNode(1, node2);

        node5.next = node2;
        System.out.println("源链表有环");
        System.out.println("检测结果：");
        System.out.println(hasCycleSlowAndFast(head));

        node5.next = null;
        System.out.println("源链表无环");
        System.out.println("检测结果：");
        System.out.println(hasCycleSlowAndFast(head));
    }

    /**
     * 通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)O(1)。
     * 慢指针每次移动一步，而快指针每次移动两步。
     * <p>
     * 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。
     * <p>
     * 现在考虑一个环形链表，把慢指针和快指针想象成两个在环形赛道上跑步的运动员（分别称之为慢跑者与快跑者）。
     * 而快跑者最终一定会追上慢跑者。这是为什么呢？考虑下面这种情况（记作情况 A）-
     * 假如快跑者只落后慢跑者一步，在下一次迭代中，它们就会分别跑了一步或两步并相遇。
     * <p>
     * 其他情况又会怎样呢？例如，我们没有考虑快跑者在慢跑者之后两步或三步的情况。
     * 但其实不难想到，因为在下一次或者下下次迭代后，又会变成上面提到的情况 A。
     * <p>
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    private static boolean hasCycleSlowAndFast(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        if (fast == null) {
            return false;
        }

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

package datastructure.linkedlist;

/**
 * Created by Ian.Lu on 2018/2/9.
 * Project : Algorithm
 */
public class SinglyLinkedList<T> {

    /**
     * 头节点
     */
    private Node firstNode;

    /**
     * 单链表包含的元素个数
     */
    private int nodeCount;

    /**
     * 增加头节点
     */
    public void insertFirst(T t) {
        Node newNode = new Node(t);
        nodeCount++;
        if (firstNode == null) {
            firstNode = newNode;
            return;
        }
        newNode.next = firstNode;
        //关键的一步，将新节点赋值给头节点
        firstNode = newNode;
    }

    /**
     * 删除头节点
     */
    public T deleteFirst() {
        if (firstNode == null) {
            System.out.println("单链表为空");
            return null;
        }
        nodeCount--;
        firstNode = firstNode.next;
        if (firstNode == null) {
            return null;
        }
        return firstNode.data;
    }

    /**
     * 插入任意位置节点
     */
    public void insert(int index, T t) {
        if (index < 0 || index > nodeCount - 1) {
            System.out.println("插入失败，链表长度:" + nodeCount);
            return;
        }
        Node newNode = new Node(t);
        Node preNode = firstNode;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        Node afterNode = preNode.next;
        preNode.next = newNode;
        newNode.next = afterNode;

        nodeCount++;
    }

    /**
     * 删除指定节点
     */
    public boolean remove(T t) {
        boolean findTag = false;
        Node preNode = null;
        Node currentNode = firstNode;
        Node afterNode;
        for (int i = 0; i < nodeCount; i++) {
            if (currentNode.data == t) {
                findTag = true;
                nodeCount--;
                break;
            } else {
                preNode = currentNode;
                currentNode = currentNode.next;
            }
        }

        if (!findTag) {
            return false;
        }

        if (preNode == null) {
            //只有头节点的前一位节点是Null
            firstNode = firstNode.next;
        } else {
            afterNode = currentNode.next;
            preNode.next = afterNode;
        }


        return true;
    }

    public void printAll() {
        StringBuffer stringBuffer = new StringBuffer("SinglyLinkedList(" + getNodeCount() + "个节点) : ");
        Node node = firstNode;
        if (node != null) {
            do {
                stringBuffer.append(node.data.toString() + " ; ");
                node = node.next;
            } while (node != null);
        }
        System.out.println(stringBuffer.toString());
    }

    public int getNodeCount() {
        return nodeCount;
    }

    class Node {
        /**
         * 数据
         */
        T data;

        /**
         * 下一节点
         */
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}

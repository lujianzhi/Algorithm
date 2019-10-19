package datastructure.linkedlist.diy;

/**
 * Created by Ian.Lu on 2018/2/9.
 * Project : Algorithm
 */
public class Test {

    public static void main(String[] args) {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<>();

        singlyLinkedList.insertFirst("1");
        singlyLinkedList.insertFirst("2");
        singlyLinkedList.insertFirst("3");
        singlyLinkedList.insertFirst("4");
        singlyLinkedList.insertFirst("5");
        singlyLinkedList.insertFirst("6");
        singlyLinkedList.insertFirst("7");

        singlyLinkedList.insert(3, "插入index = 3");

        System.out.println(singlyLinkedList.remove("3"));

//        singlyLinkedList.deleteFirst();
//        singlyLinkedList.deleteFirst();
//        singlyLinkedList.deleteFirst();

        singlyLinkedList.printAll();
    }
}

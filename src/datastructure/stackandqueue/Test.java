package datastructure.stackandqueue;

/**
 * Created by Ian.Lu on 2018/2/7.
 * Project : Algorithm
 */
public class Test {

    public static void main(String[] args) {
//        arrayStack();

        increaseQueue();
    }

    private static void increaseQueue() {
        IncreaseQueue<String> increaseQueue = new IncreaseQueue<>();

        increaseQueue.add("1");
        increaseQueue.add("2");
        increaseQueue.add("3");
        increaseQueue.add("4");
        increaseQueue.add("5");
        increaseQueue.add("6");
        increaseQueue.add("7");
        increaseQueue.add("8");
        increaseQueue.add("9");
        increaseQueue.add("10");
        increaseQueue.add("11");
        increaseQueue.add("12");

        println(increaseQueue.element());
        println(increaseQueue.remove());

        increaseQueue.add("12");
        increaseQueue.add("13");
        increaseQueue.add("14");
        increaseQueue.add("15");
        increaseQueue.add("16");

        increaseQueue.printAllDatas();

    }

    private static void arrayStack() {
        ArrayStack<String> arrayStack = new ArrayStack<>();
        arrayStack.push("祝");
        arrayStack.push("双");
        arrayStack.push("龙");
        arrayStack.push("是");
        arrayStack.push("傻");
        arrayStack.push("逼1");
        arrayStack.push("逼2");
        arrayStack.push("逼3");
        arrayStack.push("逼4");
        arrayStack.push("逼5");
        arrayStack.push("逼6");
        arrayStack.push("逼7");
        arrayStack.push("逼8");

        println(arrayStack.peek());
        println(arrayStack.pop());
        println(arrayStack.peek());
        println(arrayStack.pop());
        println(arrayStack.peek());
        println(arrayStack.pop());
        println(arrayStack.peek());
        println(arrayStack.pop());
        println(arrayStack.peek());

        arrayStack.printAllDatas();
    }

    private static void println(Object o) {
        if (o == null) {
            System.out.println("对象为空");
        } else {
            System.out.println(o.toString());
        }
    }
}

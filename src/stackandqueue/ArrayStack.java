package stackandqueue;

/**
 * 使用数组实现栈
 * Created by Ian.Lu on 2018/2/7.
 * Project : Algorithm
 */
public class ArrayStack<T> {
    /**
     * 栈内元素
     */
    private T t;

    /**
     * 栈总容量
     */
    private int maxSize;

    /**
     * 栈顶index
     */
    private int topIndex;

    /**
     * 数组
     */
    private Object[] table;

    public ArrayStack() {
        this(10);
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        table = new Object[maxSize];
        topIndex = -1;
    }

    public boolean push(T t) {
        if (isNull(t)) {
            System.out.println("不要插入空数据");
            return false;
        }

        if (isFull()) {
            System.out.println("栈已满");
            return false;
        }

        table[++topIndex] = t;

        return true;
    }

    /**
     * 返回栈顶元素，不删除
     */
    public T peek() {
        if (topIndex == 0) {
            System.out.println("栈内没有数据");
            return null;
        }
        return (T) table[topIndex];
    }

    /**
     * 返回栈顶元素，删除
     */
    public T pop() {
        if (topIndex == 0) {
            System.out.println("栈内没有数据");
            return null;
        }
        T t = (T) table[topIndex];
        table[topIndex--] = null;
        return t;
    }

    public void printAllDatas() {
        StringBuffer sb = new StringBuffer("ArrayStack : ");
        for (int i = topIndex; i >= 0; i--) {
            sb.append(table[i].toString() + "; ");
        }
        System.out.println(sb.toString());
    }

    private boolean isFull() {
        return topIndex == maxSize - 1;
    }

    private boolean isNull(T t) {
        return t == null;
    }
}

package datastructure.stackandqueue;

/**
 * 扩容队列
 * Created by Ian.Lu on 2018/2/7.
 * Project : Algorithm
 */
public class IncreaseQueue<T> {

    private static final int DEFAULT_MAX_SIZE = 10;
    private static final int DEFAULT_INCREASE_COUNT = 5;

    /**
     * 数组
     */
    private Object[] table;

    /**
     * 队列最大容量
     */
    private int maxSise;

    /**
     * 队列每次的增量
     */
    private int increaseCount;

    /**
     * 队列当前数量
     */
    private int currentCount;

    public IncreaseQueue() {
        this(DEFAULT_MAX_SIZE, DEFAULT_INCREASE_COUNT);
    }

    public IncreaseQueue(int maxSise, int increaseCount) {
        this.maxSise = maxSise;
        this.increaseCount = increaseCount;
        this.currentCount = 0;
        this.table = new Object[maxSise];
    }

    /**
     * 插入
     */
    public boolean add(T t) {
        if (needIncrease()) {
            table = newTable();
        }

        table[currentCount++] = t;
        return true;
    }

    /**
     * 删除队列头部
     */
    public T remove() {
        T t = (T) table[currentCount - 1];
        table[--currentCount] = null;
        return t;
    }

    /**
     * 获取队列头部
     */
    public T element() {
        if (currentCount < 1) {
            return null;
        }
        return (T) table[currentCount - 1];
    }

    public void printAllDatas() {
        StringBuffer stringBuffer = new StringBuffer("IncreaseQueue : ");
        for (Object o : table) {
            if (o != null) {
                stringBuffer.append(o.toString() + "; ");
            }
        }
        System.out.println(stringBuffer.toString());
    }

    /**
     * 扩容
     */
    private Object[] newTable() {
        System.out.println("扩容前容量:" + maxSise);
        Object[] newTable = new Object[maxSise + increaseCount];
        for (int i = 0; i < maxSise; i++) {
            newTable[i] = table[i];
        }
        maxSise += increaseCount;
        System.out.println("扩容后容量:" + maxSise);
        return newTable;
    }

    /**
     * 是否需要扩容
     */
    private boolean needIncrease() {
        return currentCount == maxSise;
    }
}

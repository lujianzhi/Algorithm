package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        //        testMethod();

        //        testList();

        //        shaizi();

        //        threadLocal();

        inheritableThreadLocal();

        ReentrantLock lock = new ReentrantLock();
        lock.newCondition();
    }

    private static void inheritableThreadLocal() {
        ThreadLocal<String> tl1 = new InheritableThreadLocal<>();
        tl1.set("a");
        System.out.println(Thread.currentThread().getName() + " tl1 : " + tl1.get());

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " tl1 : " + tl1.get());
            }
        }).start();

        tl1.remove();
    }

    private static void threadLocal() {
        ThreadLocal<String> tl1 = new ThreadLocal<>();
        tl1.set("a");
        ThreadLocal<String> tl2 = new ThreadLocal<>();
        tl2.set("b");
        System.out.println(Thread.currentThread().getName() + " tl1 : " + tl1.get());
        System.out.println(Thread.currentThread().getName() + " tl2 : " + tl2.get());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " tl1 : " + tl1.get());
                System.out.println(Thread.currentThread().getName() + " tl2 : " + tl2.get());
            }
        }).start();

        tl1.remove();
        tl2.remove();
    }

    private static void shaizi() {

        final Random random = new Random();

        int sun = random.nextInt(5) + 1;
        int lu = random.nextInt(5) + 1;
        System.out.println("孙:" + sun);
        System.out.println("卢:" + lu);
        System.out.println(sun == lu ? "平局" : sun > lu ? "孙赢" : "卢赢");

    }


    private static void testMethod() {
        //方法参数泛型
        //        extendsT(new A());  这行报错
        extendsT(new B());
        extendsT(new C());
        extendsT(new D());
    }

    private static void testList() {
        List<? extends B> extendsB = new ArrayList<>();
        //以下三行都报错，因为编译器无法确定List所持有的类型，所以无法安全的向其中添加对象
        //        extendsB.add(new B());
        //        extendsB.add(new C());
        //        extendsB.add(new D());
        //只有null能被添加
        extendsB.add(null);

        extendsB.contains(new B());
        extendsB.contains(new A());
        extendsB.contains(new C());

        A a = extendsB.get(0);
        B b = extendsB.get(0);
        C c = (C) extendsB.get(0);
        D d = (D) extendsB.get(0);

        List<? super B> superB = new ArrayList<>();
        //superB列表至少是B的类型，所以可以添加B或者其子类
        //        superB.add(new A());
        superB.add(new B());
        superB.add(new C());
        superB.add(new D());

        for (Object o : superB) {
            System.out.println(o.getClass().getName());
        }

    }

    private static <T extends B> void extendsT(T param) {
        System.out.println(param.getClass().getName());
    }

    //方法参数只能支持extends的泛型，不支持super
    //    private static <T super B> void superB(T param) {
    //        System.out.println(param.getClass().getName());
    //    }

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }

    static class D extends C {
    }
}

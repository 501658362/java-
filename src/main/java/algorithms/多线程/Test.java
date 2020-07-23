package algorithms.多线程;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Test extends Object {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int j = 0;
    private static volatile int h = 0;

    public static void main(String[] args) throws ExecutionException, InterruptedException, CloneNotSupportedException {

        Map<String, String> s = new HashMap<>();
//        LinkedHashMap<Integer, String> s1 = new LinkedHashMap<>(16,0.75,true);
        LinkedHashMap<Integer, String> s1 = new LinkedHashMap<>(16, 0.75f, true);

        s1.put(2, "1");
        s1.put(1, "1");
        s1.put(3, "1");
        s1.put(5, "1");
        s1.put(7, "1");
        s1.put(9, "1");
        s1.put(11, "1");
        s1.put(13, "1");
        s.put("14", "2");
        s.get("2");
        D1Thread d1 = new D1Thread();
        ExecutorService testPool = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(50);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
//        testPool.execute(d1);
//        testPool.submit(d1);
        D1Thread d2 = new D1Thread();
//        d2.start();


        Thread r1 = new Thread(new R1());
//        r1.start();

        long start = System.currentTimeMillis();
        System.out.println("========开始=====");
        FutureTask<String> task = new FutureTask<String>(new C1(5000L));
        FutureTask<String> task2 = new FutureTask<String>(new C1(3000L));
        FutureTask<String> task3 = new FutureTask<String>(new C1(7000L));
        FutureTask<String> task4 = new FutureTask<String>(new C1(7000L));
        FutureTask<String> task5 = new FutureTask<String>(new C1(7000L));
        FutureTask<String> task6 = new FutureTask<String>(new C1(7000L));
        FutureTask<String> task7 = new FutureTask<String>(new C1(7000L));
        FutureTask<String> task8 = new FutureTask<String>(new C1(7000L));
        fixedThreadPool.execute(task);
        fixedThreadPool.execute(task2);
        fixedThreadPool.execute(task3);
        fixedThreadPool.execute(task4);
        fixedThreadPool.execute(task5);
        fixedThreadPool.execute(task6);
        fixedThreadPool.execute(task7);
        fixedThreadPool.execute(task8);
        List<String> list = Lists.newArrayList();

        long end = System.currentTimeMillis();
//        fixedThreadPool.submit(task);
//        Future<?> submit = fixedThreadPool.submit(task2);
//        fixedThreadPool.submit( task3);
//        fixedThreadPool.submit( task4);
//        fixedThreadPool.submit( task5);
//        fixedThreadPool.submit( task6);
//        fixedThreadPool.submit( task7);
//        fixedThreadPool.submit( task8);
//        System.out.println(submit.get());
//        list.add((String) fixedThreadPool.submit(task).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到1 耗时：" + (end - start) + " ms");
//        list.add((String) fixedThreadPool.submit(task2).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到2 耗时：" + (end - start) + " ms");
//        list.add((String) fixedThreadPool.submit(task3).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到3 耗时：" + (end - start) + " ms");
//        list.add((String) fixedThreadPool.submit(task4).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到4 耗时：" + (end - start) + " ms");
//        list.add((String) fixedThreadPool.submit(task5).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到5 耗时：" + (end - start) + " ms");
//        list.add((String) fixedThreadPool.submit(task6).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到6 耗时：" + (end - start) + " ms");
//        list.add((String) fixedThreadPool.submit(task7).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到7 耗时：" + (end - start) + " ms");
//        list.add((String) fixedThreadPool.submit(task8).get());
//        end = System.currentTimeMillis();
//        System.out.println("=============获取到8 耗时：" + (end - start) + " ms");

        list.add(task.get());
        end = System.currentTimeMillis();
        System.out.println("=============获取到1 耗时：" + (end - start) + " ms");
        end = System.currentTimeMillis();
        list.add(task2.get());
        end = System.currentTimeMillis();
        System.out.println("=============获取到2 耗时：" + (end - start) + " ms");
        end = System.currentTimeMillis();
        list.add(task3.get());
        end = System.currentTimeMillis();
        System.out.println("=============获取到3 耗时：" + (end - start) + " ms");
        list.add(task4.get());
        list.add(task5.get());
        list.add(task6.get());
        list.add(task7.get());
        list.add(task8.get());
        end = System.currentTimeMillis();
        System.out.println("========结束 耗时：" + (end - start) + " ms");
//        d2.wait();
//        d1.wait();
//        String s = task.get();
//        System.out.println(s);

        System.out.println(list);
        System.out.println("代码结束了");
    }

    public static class F1 implements Future {

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            System.out.println("cancel");
            return false;
        }

        @Override
        public boolean isCancelled() {
            System.out.println("isCancelled");
            return false;
        }

        @Override
        public boolean isDone() {
            System.out.println("isDone");
            return false;
        }

        @Override
        public Object get() throws InterruptedException, ExecutionException {
            return null;
        }

        @Override
        public Object get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return null;
        }
    }

    public static class C1 implements Callable<String> {
        public C1() {
        }

        private long time;

        public C1(Long time) {
            this.time = time;
        }

        @Override
        public String call() throws Exception {
            System.out.println("Callable run call");
            Thread.sleep(3000);
            h++;
            System.out.println("h:" + h);
            Thread.sleep(time);
            return "Callable run call return" + System.currentTimeMillis();
        }
    }


    public static class R1 implements Runnable {

        @Override
        public void run() {
            h++;
            System.out.println("h:" + h);
            System.out.println("Runnable run");
        }
    }


    public static class D1Thread extends Thread {


        @SneakyThrows
        @Override
        public void run() {
            super.run();

            for (int i = 0; i < 5; i++) {
                if (System.currentTimeMillis() % 10 > 5) {
                    Thread.sleep(1000);
                    add();
                    h++;
                    System.out.println("h:" + h);
                    System.out.println(i + ":" + j);
                } else {
                    Thread.sleep(1500);
                    add();
                    h++;
                    System.out.println("h:" + h);
                    System.out.println(i + ":" + j);
                }
            }


        }


    }

    private static synchronized void add() throws InterruptedException {
        j++;
        System.out.println("调用j++" + j);
        Thread.sleep(1500);
    }
}

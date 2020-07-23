package algorithms;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: chenchaopeng
 * Date: 2020/4/30
 */
public class DeadThread {
    public static void main(String[] args) {
        final Lock lock1 = new ReentrantLock();
        final Lock lock2 = new ReentrantLock();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                method(lock1, lock2);
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                method(lock2, lock1);
            }
        };
        thread1.start();
        thread2.start();
        System.out.println("start interrupt...");
//        thread1.interrupt();
//        thread2.interrupt();
        System.out.println("stop interrupt....");

    }

    public static void method(Lock lock1, Lock lock2) {
        try {
//            lock1.lock();
            System.out.println("lock1.lock...");
            long starttime = System.currentTimeMillis();
            while (System.currentTimeMillis() - starttime < 1000) {
                System.out.println("等待");
            }
//            lock2.lock();
            System.out.println("lock2.lock");
        } finally {
//            lock1.unlock();
//            lock2.unlock();
        }
    }
}
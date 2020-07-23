package algorithms.多线程;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4);

        for (int i = 0; i < 4; i++) {

            final int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "开始执行任务");
                    try {
                        Thread.sleep((1000L * index));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "任务执行完了");
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "听说其他线程任务完了 提交");

                }
            }, "线程" + i).start();
        }

        System.out.println("所有线程写入完毕，继续处理其他任务...");
    }
}

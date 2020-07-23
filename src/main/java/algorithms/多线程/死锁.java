package algorithms.多线程;

public class 死锁 {


    static String x = "xy1";
    static String y = "xy2";

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                doit(y, x);

            }
        }, "AAAAA").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                doit(x, y);
            }
        }, "BBBBBB").start();

    }


    public static void doit(String x, String y) {
        synchronized (x) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到x了" + x + " 等待 y" + y);
            synchronized (y) {
                System.out.println(Thread.currentThread().getName() + "拿到y了" + y + " 等待 x" + x);
            }
        }
    }
}

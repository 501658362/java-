package algorithms.多线程;

public class 死锁1 implements Runnable {

    private String lockA;
    private String lockB;

    public static void main(String[] args) {
        String lockA = "lookA";
        String lockB = "lookB";
        new Thread(new 死锁1(lockA, lockB), "ThreadAAA").start();
        new Thread(new 死锁1(lockB, lockA), "ThreadBBB").start();
    }

    public 死锁1(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.print(Thread.currentThread().getName() + "\t自己持有" + lockA + "\t尝试获取" + lockB);
            synchronized (lockB) {
                System.out.print(Thread.currentThread().getName() + "\t自己持有" + lockB + "\t尝试获取" + lockA);
            }
        }
    }
}

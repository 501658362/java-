package algorithms.多线程;

public class 中断线程 {

    public static void main(String[] args) {

//        AtomicInteger a = new AtomicInteger();
//        a.au
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                    System.out.println("被打断了");
                }
            }
        });

        t.start();
        System.out.println("准备打断");
        t.interrupt();
    }
}

package algorithms.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test1 {
    private ExecutorService managerExecutorService;

    public static void main(String[] args) {
        Test1 t = new Test1();
        t.managerExecutorService = Executors.newSingleThreadExecutor();
        t.managerExecutorService.submit(() -> {
            System.out.println(1);
            while (true) {
                t.managerExecutorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(System.currentTimeMillis());
                    }
                });
            }
        });
    }
}

package algorithms.多线程;

import java.util.concurrent.*;

public class DemoThread extends Thread implements Runnable, Callable, Future {


    @Override
    public void run() {
        super.run();
    }

    @Override
    public Object call() throws Exception {
        return null;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return false;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    @Override
    public boolean isDone() {
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

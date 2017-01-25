package MultiThread;

import java.util.concurrent.*;

/**
 * Created by junm5 on 1/17/17.
 */
public class ExecutorsExample {
    public static void main(String [] args){
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        Future<Object> submit = newCachedThreadPool.submit(() -> null);

    }
}

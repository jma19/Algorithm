package MultiThread;

/**
 * Created by junm5 on 1/16/17.
 */
public class DeadLockExample {

    public synchronized void read() {
        update();
    }

    public synchronized void update() {
        read();
    }
}

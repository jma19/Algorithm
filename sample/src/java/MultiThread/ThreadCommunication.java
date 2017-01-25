package MultiThread;

/**
 * Created by junm5 on 1/16/17.
 */
public class ThreadCommunication {
    public static void main(String[] args) {
        Business business = new Business();
        new Thread(() -> {
            while (true) {
                try {
                    business.thread1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    business.thread2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Business {
    private boolean thread1First = true;

    public synchronized void thread1() throws InterruptedException {
        while (!thread1First) {
            this.wait();
        }
        thread1First = !thread1First;
        this.notify();
        System.out.println("thread 1 is called!!!");
        Thread.sleep(1000);
    }

    public synchronized void thread2() throws InterruptedException {
        while (thread1First) {
            this.wait();
        }

        thread1First = !thread1First;
        this.notify();
        System.out.println("thread 2 is invoked");
        Thread.sleep(1000);
    }
}

package MultiThread;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by junm5 on 1/17/17.
 */
interface Broker<T> {
    void put(T data);

    T take();
}
class Consumer implements Runnable{
    Broker<Integer> broker;
    public  Consumer(Broker broker){
        this.broker = broker;
    }
    @Override
    public void  run() {
        while (true){
            try {
                Thread.sleep(100);
                System.out.println("get data : "+broker.take());
            } catch (InterruptedException e) {
            }

        }
    }
}
class Producer implements Runnable{
    private Broker<Integer> broker;
    private Random random;
    public Producer(Broker broker, Random random){
        this.broker = broker;
        this.random = random;
    }
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = random.nextInt(100);
            System.out.println("put data : " + i );
            broker.put(i);
        }
    }
}
public class SharedQueue<T> implements Broker<T> {

    private BlockingQueue<T> blockingQueue;

    private SharedQueue() {
        this.blockingQueue = new LinkedBlockingQueue<T>();
    }

    @Override
    public void put(T data) {
        try {
            blockingQueue.put(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public T take() {
        try {
            return blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        SharedQueue<Integer> sharedQueue = new SharedQueue<Integer>();
        Consumer consumer = new Consumer(sharedQueue);
        Producer producer = new Producer(sharedQueue, new Random());

        new Thread(consumer).start();
        new Thread(producer).start();

    }

}

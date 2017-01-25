package Applovin;

import java.util.Random;

/**
 * Created by junm5 on 1/16/17.
 */
public class JavaProgrammingExercise {
    public static void main(String[] args) throws InterruptedException {
        int numOfThread = 4, dataLen = 4;
        Calculator[] calculators = new Calculator[numOfThread];

        Random random = new Random();
        int[] data = new int[dataLen];
        System.out.print("Random generate data:");
        for (int i = 0; i < dataLen; i++) {
            data[i] = random.nextInt(10);
            System.out.print(data[i] + " ");
        }
        for (int i = 0; i < numOfThread; i++) {
            calculators[i] = new Calculator(data, i * dataLen / numOfThread, (i + 1) * dataLen / numOfThread);
            calculators[i].start();
        }
        int sum = 0;
        for (int i = 0; i < numOfThread; i++) {
            calculators[i].join();
            sum += calculators[i].getAns();
        }
        System.out.println();
        System.out.println("Total Sum:" + sum);

    }
}

class Calculator extends Thread {
    private int[] data;
    private int start, end, ans = 0;

    public Calculator(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            ans += data[i];
        }
    }

    public int getAns() {
        return ans;
    }
}